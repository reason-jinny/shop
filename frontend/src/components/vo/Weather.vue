<template>
    <div>
        <v-card-title v-if="editMode">
            {{label}}
        </v-card-title>
        <v-card-title  v-if="!editMode">
            Today's Weather
        </v-card-title>

        <v-card-text v-if="value">
            <div v-if="editMode">
                <v-text-field type="number" label="Degree" v-model="value.degree"/>
            </div>
            <div v-if="editMode">
                <v-text-field type="number" label="Precipitation" v-model="value.precipitation"/>
            </div>
            <div v-if="editMode">
                <v-text-field type="number" label="Humidity" v-model="value.humidity"/>
            </div>
            <div v-if="editMode">
                <v-text-field type="number" label="Wind" v-model="value.wind"/>
            </div>
            <v-card
                v-if="!editMode"
                class="mx-auto"
                height="230"
                width="400"
            >
                <v-img
                    height="100%"
                    :src="weatherBg"
                >
                    <div v-if="!editMode" style="font-size:70px; margin:50px 0 50px 20px;">
                        <div v-if="value.precipitation<25">
                            <span style="color:gold" class="mdi mdi-white-balance-sunny"></span>
                        </div>
                        <div v-else-if="25<=value.precipitation && value.precipitation<70">
                            <span style="color:grey" class="mdi mdi-weather-cloudy"></span>
                        </div>
                        <div v-else-if="70<=value.precipitation">
                            <span style="color:navy" class="mdi mdi-weather-pouring"></span>
                        </div>
                    </div>

                    <div v-if="!editMode" style="font-size:25px; font-weight:500; margin-left:20px; color:white;">
                            온도 {{value.degree }}&nbsp;<v-icon x-large color="secondary">mdi-temperature-celsius</v-icon>&nbsp;&nbsp;
                            풍속 {{value.wind }}km/h&nbsp;<v-icon x-large color="secondary">mdi-weather-windy-variant</v-icon><br>
                            강수확률 {{value.precipitation }}%&nbsp;<v-icon x-large color="secondary">mdi-umbrella</v-icon>&nbsp;&nbsp;
                            습도 {{value.humidity }}%&nbsp;<v-icon x-large color="secondary">mdi-weather-rainy</v-icon>
                    </div>
                </v-img>
            </v-card>
        </v-card-text>
    </div>
</template>

<script>
    export default {
        name:"Weather",
        props: {
            editMode: Boolean,
            value : Object,
            label : String,
        },
        data: () => ({
            weatherBg: null,
        }),
        created(){
            if(!this.value) {
                this.value = {
                    'degree': 0,
                    'precipitation': 0,
                    'humidity': 0,
                    'wind': 0,
                };
            }
            if(this.value.precipitation<25) {
                this.weatherBg = "https://user-images.githubusercontent.com/92732781/174241118-7832da47-bbb8-481c-a11a-737a6b986104.png";
            } else if(this.value.precipitation>=25 && this.value.precipitation<70) {
                this.weatherBg = "https://user-images.githubusercontent.com/92732781/174242976-3f6d5bda-7bcb-404b-a299-84961e2f0c54.png";
            } else if(this.value.precipitation>=70) {
                this.weatherBg = "https://user-images.githubusercontent.com/92732781/174243446-886452db-083a-4882-b02e-efd577ce17f6.png";
            }

        },
        watch: {
            value(newVal) {
                this.$emit('input', newVal);
            },
        },
    }
</script>

<style scoped>
</style>