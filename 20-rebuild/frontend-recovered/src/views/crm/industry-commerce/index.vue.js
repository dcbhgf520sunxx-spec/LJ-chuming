import { x as k, o as x, G as N, P as C } from "../../../shared/runtime.js";
import { ref as P } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as E } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withCtx as l } from "vue";
import { createBlock as n } from "vue";
import { createCommentVNode as r } from "vue";
import { createTextVNode as A } from "vue";
import { ElMessage as B } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { ElPopconfirm as M } from "element-plus";
import { c as R, _ as V, u as D } from "./module/header.vue.js";
import { v as c } from "../../../modules/crm-c6ba92ff.js";
const H = { class: "app-container" }, Q = { __name: "index", setup(I) {
  const m = P(), f = { batchAdd: false, add: false, edit: false, del: false, download: false }, { crud: p, columns: a } = k({ title: "工商企业信息库", crudApi: { ...R }, permission: { ...c }, optShow: { ...f }, hasPagination: true }, m), { maxHeight: _ } = x({ paginate: true });
  async function b(d) {
    try {
      await D({ id: d.id }), B.success("更新成功"), p.toQuery();
    } catch (s) {
      console.log(s);
    }
  }
  return (d, s) => {
    const o = F, h = u("common-button"), w = M, y = u("common-table"), g = C;
    return t(), E("div", H, [i(V, { permission: e(c) }, null, 8, ["permission"]), i(y, { ref_key: "tableRef", ref: m, data: e(p).data, "max-height": e(_) }, { default: l(() => [i(o, { type: "index", align: "center", label: "序号" }), e(a).visible("companyName") ? (t(), n(o, { key: 0, "show-overflow-tooltip": true, align: "center", label: "企业名称", prop: "companyName", width: "200" })) : r("", true), e(a).visible("creditCode") ? (t(), n(o, { key: 1, "show-overflow-tooltip": true, align: "center", label: "社会统一信用代码", prop: "creditCode", width: "200" })) : r("", true), e(a).visible("address") ? (t(), n(o, { key: 2, "show-overflow-tooltip": true, align: "center", label: "企业地址", prop: "address", width: "500" })) : r("", true), e(a).visible("keyPersonName") ? (t(), n(o, { key: 3, "show-overflow-tooltip": true, align: "center", label: "企业联系人", prop: "keyPersonName", width: "120" })) : r("", true), e(a).visible("email") ? (t(), n(o, { key: 4, "show-overflow-tooltip": true, align: "center", label: "企业邮箱", prop: "email" })) : r("", true), e(a).visible("phoneNumber") ? (t(), n(o, { key: 5, "show-overflow-tooltip": true, align: "center", label: "企业联系电话", prop: "phoneNumber" })) : r("", true), e(a).visible("companyName") & e(N)(e(c).update) ? (t(), n(o, { key: 6, align: "center", label: "操作" }, { default: l(({ row: v }) => [i(w, { title: "注意：更新操作会耗费查询工商信息流量", onConfirm: (S) => b(v) }, { reference: l(() => [i(h, { icon: "el-icon-edit", type: "primary" }, { default: l(() => s[0] || (s[0] = [A("更新")])), _: 1, __: [0] })]), _: 2 }, 1032, ["onConfirm"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "max-height"]), i(g)]);
  };
} };
export {
  Q as default
};
