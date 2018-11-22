org.springframework.cloud.contract.spec.Contract.make {
  request {
    method 'GET'
    url '/heroes'
    headers {
      header('Content-Type', 'application/json')
    }
  }
response {
  status 200
    body('''
    [{
      "id":"4",
      "name":"Nico"
    },
    {
      "id":"2",
      "name":"Nani"
    },
    {
      "id":"3",
      "name":"Mausi"
    },
    {
      "id":"5",
      "name":"Vera"
    }]
    ''')
  headers {
    header('Content-Type': 'application/json;charset=UTF-8')
  }
 }
}