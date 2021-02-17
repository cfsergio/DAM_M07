var vm = new Vue({
    el: '#eltemps',
    data: {
        ciutatActual: null,
		ciutats: [
				"Barcelona",
				"Lleida",
				"Zaragoza",
				"Sevilla",
				"Madrid",
				"Paris",
				"Melbourne",
				"Moscow",
				"Pekin",
				"Marrakech"]
    },
    created: function () {
        this.getWeather(this.ciutats[0]);
    },
    methods: {
        getWeather(city) {
            var url ='https://api.openweathermap.org/data/2.5/weather?q=' + city + '&units=metric&lang=ca&appid=e45272a1eff49e21a99d62aa7f11153d'
            fetch(url)
                .then(function (response) {
                    return response.json()
                })
                .then(function (item) {
                    vm.ciutatActual = item;
                })
                .catch(function(error) {
                    console.log(error);
                })
        },
        getIcon(codi){
            var url_base = "http://openweathermap.org/img/wn/" + codi + "@2x.png";
            return url_base
        }
    }
})


