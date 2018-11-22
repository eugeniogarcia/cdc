org.springframework.cloud.contract.spec.Contract.make {
  request {
    method 'POST'
    url '/heroes'
    body('''
    {
      "name":"Vera"
    }
    ''')
    headers {
      header('Content-Type', 'application/json')
    }
  }
response {
  status 200
    body('''
    {
      "id":"5",
      "name":"Vera"
    }
    ''')
  headers {
    header('Content-Type': 'application/json;charset=UTF-8')
  }
 }
}