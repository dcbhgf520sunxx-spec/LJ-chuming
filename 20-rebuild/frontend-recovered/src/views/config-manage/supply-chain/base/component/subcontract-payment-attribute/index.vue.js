import { ref as F } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as M } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as u } from "vue";
import { createVNode as d } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as f } from "vue";
import { withDirectives as v } from "vue";
import { createBlock as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as S } from "vue";
import { createCommentVNode as _ } from "vue";
import { Fragment as w } from "vue";
import { ElMessage as O } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { ElInput as H } from "element-plus";
import { ElInputNumber as Q } from "element-plus";
import { ElPopconfirm as Y } from "element-plus";
import { ElCard as j } from "element-plus";
import { vLoading as q } from "element-plus";
import { c as b } from "../../../../../../modules/subcontract-payment-attribute-37f9bab7.js";
import { _ as G, x as L, fX as c, o as X, G as h } from "../../../../../../shared/runtime.js";
import J from "./module/form.vue.js";
const K = { class: "clearfix" }, W = { key: 1 }, Z = { key: 1 }, ee = { class: "app-container" }, te = { __name: "index", setup(oe) {
  const V = { add: true, edit: false, del: false, download: false }, x = F(), { crud: r, CRUD: k, columns: C } = L({ title: "付款属性", sort: [], permission: { ...c }, optShow: { ...V }, crudApi: { ...b }, hasPagination: false }, x), { maxHeight: E } = X({ wrapperBox: ".subcontractPaymentAttribute", paginate: true, extraHeight: 200 });
  async function I(n) {
    if (!n.name) {
      O.error("请填写付款属性");
      return;
    }
    try {
      await b.edit(n), r.notify("修改成功", k.NOTIFICATION_TYPE.SUCCESS), n.edit = false, r.toQuery();
    } catch (a) {
      console.log("付款属性", a);
    }
  }
  async function N(n) {
    try {
      await b.del([n.id]), r.notify("删除成功", k.NOTIFICATION_TYPE.SUCCESS), r.toQuery();
    } catch (a) {
      console.log("删除", a);
    }
  }
  function P(n) {
    n.name = n.sourceRow.name, n.sort = n.sourceRow.sort, n.edit = false;
  }
  return (n, a) => {
    const m = g("common-button"), p = $, T = H, A = Q, R = Y, U = g("common-table"), D = j, z = M("permission"), B = q;
    return o(), u(w, null, [d(D, { shadow: "always" }, { header: i(() => [f("div", K, [a[1] || (a[1] = f("span", { class: "card-title" }, "付款申请-付款属性", -1)), v((o(), l(m, { size: "default", type: "primary", style: { float: "right" }, onClick: e(r).toAdd }, { default: i(() => a[0] || (a[0] = [y(" 新增 ")])), _: 1, __: [0] }, 8, ["onClick"])), [[z, e(c).add]])])]), default: i(() => [v((o(), l(U, { ref_key: "tableRef", ref: x, data: e(r).data, "empty-text": e(r).emptyText, "max-height": e(E), style: { width: "100%" } }, { default: i(() => [d(p, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(C).visible("name") ? (o(), l(p, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "付款属性", "min-width": "150" }, { default: i((t) => [t.row.edit ? (o(), l(T, { key: 0, modelValue: t.row.name, "onUpdate:modelValue": (s) => t.row.name = s, type: "text", placeholder: "付款属性", style: { width: "100%" }, maxlength: "50" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), u("div", W, S(t.row.name), 1))]), _: 1 })) : _("", true), e(C).visible("sort") ? (o(), l(p, { key: "sort", prop: "sort", "show-overflow-tooltip": true, label: "排序", "min-width": "150" }, { default: i((t) => [t.row.edit ? (o(), l(A, { key: 0, modelValue: t.row.sort, "onUpdate:modelValue": (s) => t.row.sort = s, modelModifiers: { number: true }, min: 1, max: 999, step: 1, "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), u("div", Z, S(t.row.sort), 1))]), _: 1 })) : _("", true), e(h)([...e(c).del, ...e(c).edit]) ? (o(), l(p, { key: 2, label: "操作", width: "150px", align: "center", fixed: "right" }, { default: i((t) => [t.row.edit ? (o(), u(w, { key: 0 }, [d(m, { type: "info", size: "default", onClick: (s) => P(t.row) }, { default: i(() => a[2] || (a[2] = [y("取消")])), _: 2, __: [2] }, 1032, ["onClick"]), d(m, { type: "primary", size: "default", onClick: (s) => I(t.row) }, { default: i(() => a[3] || (a[3] = [y("保存")])), _: 2, __: [3] }, 1032, ["onClick"])], 64)) : (o(), u(w, { key: 1 }, [e(h)(e(c).edit) ? (o(), l(m, { key: 0, size: "default", icon: "el-icon-edit", type: "primary", onClick: (s) => t.row.edit = true }, null, 8, ["onClick"])) : _("", true), e(h)(e(c).del) ? (o(), l(R, { key: 1, "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定删除吗?", onConfirm: (s) => N(t.row) }, { reference: i(() => [d(m, { size: "default", icon: "el-icon-delete", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])) : _("", true)], 64))]), _: 1 })) : _("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[B, e(r).loading]])]), _: 1 }), f("div", ee, [d(e(J))])], 64);
  };
} }, re = G(te, [["__scopeId", "data-v-5e989729"]]);
export {
  re as default
};
