var client_id = '8efae0f31d034d14a59ba0083db7f6f2';
var client_secret = '6f83e2a7c759413a9428aaf10d9ed84e';

var authOptions = {
  url: 'https://accounts.spotify.com/api/token',
  headers: {
    'Authorization': 'Basic ' + (new Buffer(client_id + ':' + client_secret).toString('base64'))
  },
  form: {
    grant_type: 'client_credentials'
  },
  json: true
};

request.post(authOptions, function(error, response, body) {
  if (!error && response.statusCode === 200) {
    var token = body.access_token;
  }
});

console.log(token)