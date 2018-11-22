org.springframework.cloud.contract.spec.Contract.make {
  request {
    method 'GET'
    url '/heroes/2'
  }
response {
  status 200
    body('''
    {
      "id":"2",
      "name":"Nani"
    }
    ''')
  headers {
    header('Content-Type': 'application/json;charset=UTF-8')
  }
 }
}