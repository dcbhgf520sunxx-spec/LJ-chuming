import { ref as E } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as P } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as l } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as s } from "vue";
import { toDisplayString as f } from "vue";
import { ElMessageBox as V } from "element-plus";
import { ElTableColumn as N } from "element-plus";
import { ElSwitch as R } from "element-plus";
import { vLoading as U } from "element-plus";
import { _ as I, x as $, ga as m, gb as A, o as M, gc as O, br as F, gd as y, G as h, an as H, P as L, ge as q } from "../../../../shared/runtime.js";
import { u as G } from "../../../../modules/use-crud-enabled-change-d83074a3.js";
import Y from "./module/header.vue.js";
import j from "./module/form.vue.js";
import z from "./module/detail.vue.js";
import "../../../../modules/index-5e774f84.js";
import "../../../../modules/index-73880c3c.js";
import "../../../../modules/vertical-label-c3028fe0.js";
const J = { class: "app-container" }, K = { class: "head-container" }, Q = { style: { "margin-left": "15px" } }, W = { __name: "index", setup(X) {
  const x = { add: true, edit: false, del: false, download: false }, b = E(), { crud: r, columns: c, CRUD: g } = $({ title: "表格模板", sort: [], permission: { ...m }, optShow: { ...x }, crudApi: { ...A }, hasPagination: true }, b), { maxHeight: w } = M({ paginate: true }), { handleEnabledChange: k } = G({ CRUD: g, crud: r, editEnabled: O });
  async function v(u) {
    if (h(m.edit)) try {
      const d = !u.isDefault, a = d ? `此操作将“${u.name}”设置为该表格的默认模板` : `此操作取消“${u.name}”的默认状态`;
      await V.confirm(a, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await q({ id: u.id, isDefault: d }), r.refresh(), r.notify(d ? "设置" : "取消成功", g.NOTIFICATION_TYPE.SUCCESS);
    } catch (d) {
      console.log("变更表格状态", d);
    }
  }
  return (u, d) => {
    const a = N, C = R, T = B("common-table"), D = U;
    return o(), P("div", J, [_("div", K, [i(e(Y))]), S((o(), l(T, { ref_key: "tableRef", ref: b, data: e(r).data, "empty-text": e(r).emptyText, "max-height": e(w), style: { width: "100%" }, onRowDblclick: v }, { default: p(() => [i(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(c).visible("name") ? (o(), l(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "表格名称", "min-width": "140px" }, { default: p(({ row: t }) => [t.isDefault ? (o(), l(F, { key: 0, name: "默认" })) : s("", true), _("span", Q, f(t.name), 1)]), _: 1 })) : s("", true), e(c).visible("moduleType") ? (o(), l(a, { key: "moduleType", prop: "moduleType", "show-overflow-tooltip": true, label: "模块", "min-width": "140px" }, { default: p(({ row: t }) => {
      var n;
      return [_("span", null, f((n = e(y)[t.type]) == null ? void 0 : n.T), 1)];
    }), _: 1 })) : s("", true), e(c).visible("type") ? (o(), l(a, { key: "type", prop: "type", "show-overflow-tooltip": true, label: "表格", "min-width": "140px" }, { default: p(({ row: t }) => {
      var n;
      return [_("span", null, f((n = e(y)[t.type]) == null ? void 0 : n.L), 1)];
    }), _: 1 })) : s("", true), e(c).visible("remark") ? (o(), l(a, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "160px" })) : s("", true), e(c).visible("remark") ? (o(), l(a, { key: "remark", prop: "remark", label: "状态", align: "center", width: "80px" }, { default: p(({ row: t }) => [i(C, { modelValue: t.enabled, "onUpdate:modelValue": (n) => t.enabled = n, disabled: !e(h)(e(m).edit), onChange: (n) => e(k)(t, "name") }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"])]), _: 1 })) : s("", true), e(h)([...e(m).detail, ...e(m).del, ...e(m).edit]) ? (o(), l(a, { key: 5, label: "操作", width: "170px", align: "center", fixed: "right" }, { default: p(({ row: t }) => [i(e(H), { "show-detail": true, data: t }, null, 8, ["data"])]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[D, e(r).loading]]), i(e(L)), i(e(z)), i(e(j))]);
  };
} }, re = I(W, [["__scopeId", "data-v-5ec65158"]]);
export {
  re as default
};
