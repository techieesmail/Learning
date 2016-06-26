var http = require('http');
var sys = require('sys');
var fs = require('fs');

http.createServer(function(req, res) {
  debugHeaders(req);

  if (true) {
    if (req.url == '/events') {
      console.log('constructing SSE ');
      sendSSE(req, res);
    } else if(req.url == '/html'){
      console.log('Inside html code ');
      res.writeHead(200, {
        'Content-Type': 'text/html',
        'Cache-Control': 'no-cache',
        'Connection': 'keep-alive',
        'Access-Control-Allow-Origin' :'*',
        'Access-Control-Allow-Methods': 'POST, GET, OPTIONS'
      });
      res.write('Hello from node js')
      setInterval(function(){
        console.log('setInterval of html called ');
        res.write('From setInterval');
      },5000);
    }else {
      res.writeHead(404);
      res.end();
    }
  } else {
    res.writeHead(200, {'Content-Type': 'text/html'});
    //res.write(fs.readFileSync(__dirname + '/sse-node.html'));
    res.write('Events page not found ');
    res.end();
  }
}).listen(8000,'localhost');

function sendSSE(req, res) {
  res.writeHead(200, {
    'Content-Type': 'text/event-stream',
    'Cache-Control': 'no-cache',
    'Connection': 'keep-alive',
    'Access-Control-Allow-Origin' :'*',
    'Access-Control-Allow-Methods': 'POST, GET, OPTIONS'
  });

  var id = (new Date()).toLocaleTimeString();

  setInterval(function() {
    constructSSE(res, id, (new Date()).toLocaleTimeString());
  }, 5000);

  constructSSE(res, id, (new Date()).toLocaleTimeString());
  res.end();
}

function constructSSE(res, id, data) {
  res.write('id: ' + id + '\n');
  res.write("data: " + data + '\n\n');
}

function debugHeaders(req) {
  sys.puts('URL: ' + req.url);
  for (var key in req.headers) {
    sys.puts(key + ': ' + req.headers[key]);
  }
  sys.puts('\n\n');
}