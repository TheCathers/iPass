import Layout from '../layout'

/**
 * hidden: true                  如果设置为 true，该项菜单将不会显示在菜单栏中(默认为 false)
 * meta : {
    title: 'title'               菜单名
    icon: 'icon-name'            图标名
    fixed: true                  如果设置为 true，该项 tag 将一直存在 tag 栏中(默认为 false)
  }
 * */

export const asyncRoutes = [
  {
    path: '/form-table',
    name: 'FormTable',
    component: Layout,
    redirect: '/form-table/table-classic',
    meta: {
      title: '卡片管理',
      icon: 'vue-dsn-icon-biaoge'
    },
    children: [
      {
        path: 'table-classic',
        name: 'CardInfo',
        component: () => import('../views/form-table/CardInfo'),
        meta: {
          title: '卡片信息'
        }
      },

      {
        path: 'table-inline-edit',
        name: 'TableInlineEdit',
        component: () => import('../views/form-table/CardApprove'),
        meta: {
          title: '卡片审批'
        }
      }
    ]
  },
  {
    path: '/admin',
    name: 'Editors',
    component: Layout,
    redirect: '/editors/markdown',
    meta: {
      title: '系统管理',
      icon: 'vue-dsn-icon-bianjiqi'
    },
    children: [
      {
        path: 'markdown',
        name: 'Markdown',
        component: () => import('../views/editors/UserAdmin'),
        meta: {
          title: '人员管理'
        }
      },
      {
        path: 'rich-text',
        name: 'ImageRichText',
        component: () => import('../views/editors/RichTextEditor'),
        meta: {
          title: '权限管理'
        }
      },
      {
        path: 'rich-text',
        name: 'ImageRichText',
        component: () => import('../views/editors/RichTextEditor'),
        meta: {
          title: '菜单管理'
        }
      },
      {
        path: 'rich-text',
        name: 'ImageRichText',
        component: () => import('../views/editors/RichTextEditor'),
        meta: {
          title: '医生排班'
        }
      },
      {
        path: 'rich-text',
        name: 'ImageRichText',
        component: () => import('../views/editors/RichTextEditor'),
        meta: {
          title: '日志查看'
        }
      },
      {
        path: 'rich-text',
        name: 'ImageRichText',
        component: () => import('../views/editors/RichTextEditor'),
        meta: {
          title: '参数管理'
        }
      }
    ]
  },
]
