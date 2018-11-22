org.springframework.cloud.contract.spec.Contract.make {
  request {
    method 'DELETE'
    url '/heroes/120'
    headers {
      header('Content-Type', 'application/json')
    }
  }
response {
  status 400
 }
}