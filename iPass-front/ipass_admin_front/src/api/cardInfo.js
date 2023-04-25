import request from '@/request'
import { Message } from 'element-ui'

export default {
  getPageList(page, limit, searchObj) {
    const api_name = '/service_admin/pageCardCondition'
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'post',
      data: searchObj
    })
  },
  addNewCard(prefix,from,to) {
    const api_name = '/service_admin/addCardInfo'
    return request({
      url: `${api_name}/${prefix}/${from}/${to}`,
      method: 'get'
    })
  },
  removeDataById(id) {
    const api_name = '/service_admin/removeDataById'
    return request({
      url: `${api_name}/${id}`,
      method: 'delete'
    })
  }
}
