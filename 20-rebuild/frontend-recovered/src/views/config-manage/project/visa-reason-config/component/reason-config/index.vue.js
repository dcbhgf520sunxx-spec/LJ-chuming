import { ref as A } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as r } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as f } from "vue";
import { withDirectives as v } from "vue";
import { createBlock as s } from "vue";
import { unref as e } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as F } from "vue";
import { createCommentVNode as p } from "vue";
import { Fragment as x } from "vue";
import { ElMessage as M } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { ElInput as $ } from "element-plus";
import { ElPopconfirm as H } from "element-plus";
import { ElCard as j } from "element-plus";
import { vLoading as L } from "element-plus";
import { _ as Y, x as q, fL as d, fM as C, o as G, G as g } from "../../../../../../shared/runtime.js";
import Q from "./module/form.vue.js";
const J = { class: "clearfix" }, K = { key: 1 }, W = { class: "app-container" }, X = { __name: "index", setup(Z) {
  const b = { add: true, edit: false, del: false, download: false }, w = A(), { crud: l, CRUD: h, columns: S } = q({ title: "签证原因", sort: [], permission: { ...d }, optShow: { ...b }, crudApi: { ...C }, hasPagination: false }, w), { maxHeight: E } = G({ wrapperBox: ".visaReasonConfig", paginate: true, extraHeight: 40 });
  async function R(a) {
    if (!a.name) {
      M.error("请填写签证原因");
      return;
    }
    try {
      await C.edit(a), l.notify("修改成功", h.NOTIFICATION_TYPE.SUCCESS), a.edit = false;
    } catch (t) {
      console.log("签证原因", t);
    }
  }
  async function T(a) {
    try {
      await C.del([a.id]), l.notify("删除成功", h.NOTIFICATION_TYPE.SUCCESS), l.toQuery();
    } catch (t) {
      console.log("删除", t);
    }
  }
  function V(a) {
    a.name = a.sourceRow.name, a.edit = false;
  }
  return (a, t) => {
    const c = k("common-button"), u = O, I = $, N = H, D = k("common-table"), P = j, U = B("permission"), z = L;
    return o(), _(x, null, [r(P, { shadow: "always" }, { header: i(() => [f("div", J, [t[1] || (t[1] = f("span", { class: "card-title" }, "分包签证原因", -1)), v((o(), s(c, { size: "default", type: "primary", style: { float: "right" }, onClick: e(l).toAdd }, { default: i(() => t[0] || (t[0] = [y(" 新增 ")])), _: 1, __: [0] }, 8, ["onClick"])), [[U, e(d).add]])])]), default: i(() => [v((o(), s(D, { ref_key: "tableRef", ref: w, data: e(l).data, "empty-text": e(l).emptyText, "max-height": e(E), style: { width: "100%" } }, { default: i(() => [r(u, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(S).visible("name") ? (o(), s(u, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "分包签证原因", "min-width": "150" }, { default: i((n) => [n.row.edit ? (o(), s(I, { key: 0, modelValue: n.row.name, "onUpdate:modelValue": (m) => n.row.name = m, type: "text", placeholder: "分包签证原因", style: { width: "260px" }, maxlength: "50" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), _("div", K, F(n.row.name), 1))]), _: 1 })) : p("", true), e(g)([...e(d).del, ...e(d).edit]) ? (o(), s(u, { key: 1, label: "操作", width: "150px", align: "center", fixed: "right" }, { default: i((n) => [n.row.edit ? (o(), _(x, { key: 0 }, [r(c, { type: "info", size: "default", onClick: (m) => V(n.row) }, { default: i(() => t[2] || (t[2] = [y("取消")])), _: 2, __: [2] }, 1032, ["onClick"]), r(c, { type: "primary", size: "default", onClick: (m) => R(n.row) }, { default: i(() => t[3] || (t[3] = [y("保存")])), _: 2, __: [3] }, 1032, ["onClick"])], 64)) : (o(), _(x, { key: 1 }, [e(g)(e(d).edit) ? (o(), s(c, { key: 0, size: "default", icon: "el-icon-edit", type: "primary", onClick: (m) => n.row.edit = true }, null, 8, ["onClick"])) : p("", true), e(g)(e(d).del) ? (o(), s(N, { key: 1, "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定删除吗?", onConfirm: (m) => T(n.row) }, { reference: i(() => [r(c, { size: "default", icon: "el-icon-delete", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])) : p("", true)], 64))]), _: 1 })) : p("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[z, e(l).loading]])]), _: 1 }), f("div", W, [r(e(Q))])], 64);
  };
} }, ae = Y(X, [["__scopeId", "data-v-1eb54837"]]);
export {
  ae as default
};
