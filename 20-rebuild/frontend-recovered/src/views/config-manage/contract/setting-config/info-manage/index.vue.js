import { ref as S } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as V } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as c } from "vue";
import { withCtx as m } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as d } from "vue";
import { ElMessageBox as x } from "element-plus";
import { ElTableColumn as D } from "element-plus";
import { ElSwitch as F } from "element-plus";
import { vLoading as M } from "element-plus";
import { c as R, m as I, e as P, a as A } from "./module/form.vue.js";
import { _ as L, x as O, dr as u, o as $, br as H, G as v, cB as s, an as Y, P as q } from "../../../../../shared/runtime.js";
import G from "./module/header.vue.js";
const j = { class: "app-container" }, z = { class: "head-container" }, J = { __name: "index", setup(K) {
  const b = { add: true, edit: false, del: false, download: false }, f = S(), { crud: i, columns: p, CRUD: h } = O({ title: "项目成员模板", sort: [], permission: { ...u }, optShow: { ...b }, crudApi: { ...R }, hasPagination: true }, f), { maxHeight: y } = $({ wrapperBox: ".memberConfig", paginate: true, extraHeight: 40 });
  async function E(a) {
    try {
      const o = !a.isDefault, n = o ? `此操作将“${a.templateName}”设置为该表格的默认模板` : `此操作取消“${a.templateName}”的默认状态`;
      await x.confirm(n, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await P({ id: a.id, isDefault: o }), i.refresh(), i.notify(o ? "设置" : "取消成功", h.NOTIFICATION_TYPE.SUCCESS);
    } catch (o) {
      console.log("变更表格状态", o);
    }
  }
  async function C(a, o) {
    try {
      await x.confirm('此操作将 "' + s.VL[o] + '" ' + a.templateName + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await A({ id: a.id, status: o }), i.refresh(), i.notify(s.VL[o] + "成功", h.NOTIFICATION_TYPE.SUCCESS);
    } catch (n) {
      console.log("变更成员模板状态", n), a.status = a.status === s.ENUM.TRUE.V ? s.ENUM.FALSE.V : s.ENUM.TRUE.V;
    }
  }
  return (a, o) => {
    const n = D, N = F, k = U("common-table"), T = M;
    return r(), V("div", j, [_("div", z, [l(e(G))]), B((r(), c(k, { ref_key: "tableRef", ref: f, data: e(i).data, "empty-text": e(i).emptyText, "max-height": e(y), onRowDblclick: E, "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: m(() => [l(n, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(p).visible("templateName") ? (r(), c(n, { key: "templateName", prop: "templateName", "show-overflow-tooltip": true, label: "模板名称", align: "center", "min-width": "100" }, { default: m((t) => [l(H, { show: t.row.isDefault, name: "默认" }, null, 8, ["show"]), _("div", null, g(t.row.templateName), 1)]), _: 1 })) : d("", true), e(p).visible("remark") ? (r(), c(n, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "描述信息", align: "center", "min-width": "180" }, { default: m((t) => [_("div", null, g(t.row.remark), 1)]), _: 1 })) : d("", true), e(p).visible("remark") ? (r(), c(n, { key: "remark", prop: "remark", label: "状态", align: "center", width: "140" }, { default: m((t) => [l(N, { modelValue: t.row.status, "onUpdate:modelValue": (w) => t.row.status = w, disabled: !e(v)(e(u).edit), "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(s).ENUM.TRUE.V, "inactive-value": e(s).ENUM.FALSE.V, onChange: (w) => C(t.row, t.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])]), _: 1 })) : d("", true), e(v)([...e(u).del, ...e(u).edit]) ? (r(), c(n, { key: 3, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: m((t) => [l(e(Y), { data: t.row }, null, 8, ["data"])]), _: 1 })) : d("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[T, e(i).loading]]), l(e(q)), l(e(I))]);
  };
} }, te = L(J, [["__scopeId", "data-v-854dc8cd"]]);
export {
  te as default
};
