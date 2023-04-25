import request from '../request'

export function login(data) {
  return request({
    url: '/service_admin/login',
    method: 'post',
    data
  })
}

export function getUserInfo(params) {
  return request({
    url: '/service_admin/info',
    method: 'get',
    params
  })
}
