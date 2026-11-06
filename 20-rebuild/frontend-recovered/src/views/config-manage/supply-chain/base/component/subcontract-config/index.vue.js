import { ref as A } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as s } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as f } from "vue";
import { withDirectives as v } from "vue";
import { createBlock as r } from "vue";
import { unref as e } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as F } from "vue";
import { createCommentVNode as u } from "vue";
import { Fragment as x } from "vue";
import { ElMessage as O } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { ElInput as H } from "element-plus";
import { ElPopconfirm as M } from "element-plus";
import { ElCard as Y } from "element-plus";
import { vLoading as j } from "element-plus";
import { _ as q, x as G, fV as d, fW as w, o as L, G as C } from "../../../../../../shared/runtime.js";
import Q from "./module/form.vue.js";
const W = { class: "clearfix" }, J = { key: 1 }, K = { class: "app-container" }, X = { __name: "index", setup(Z) {
  const b = { add: true, edit: false, del: false, download: false }, g = A(), { crud: l, CRUD: h, columns: S } = G({ title: "分包类别", sort: [], permission: { ...d }, optShow: { ...b }, crudApi: { ...w }, hasPagination: false }, g), { maxHeight: E } = L({ wrapperBox: ".subcontractConfig", paginate: true, extraHeight: 200 });
  async function T(a) {
    if (!a.name) {
      O.error("请填写分包类别");
      return;
    }
    try {
      await w.edit(a), l.notify("修改成功", h.NOTIFICATION_TYPE.SUCCESS), a.edit = false;
    } catch (t) {
      console.log("分包类别", t);
    }
  }
  async function V(a) {
    try {
      await w.del([a.id]), l.notify("删除成功", h.NOTIFICATION_TYPE.SUCCESS), l.toQuery();
    } catch (t) {
      console.log("删除", t);
    }
  }
  function I(a) {
    a.name = a.sourceRow.name, a.edit = false;
  }
  return (a, t) => {
    const c = k("common-button"), p = $, N = H, R = M, D = k("common-table"), P = Y, U = B("permission"), z = j;
    return n(), _(x, null, [s(P, { shadow: "always" }, { header: i(() => [f("div", W, [t[1] || (t[1] = f("span", { class: "card-title" }, "分包类别", -1)), v((n(), r(c, { size: "default", type: "primary", style: { float: "right" }, onClick: e(l).toAdd }, { default: i(() => t[0] || (t[0] = [y(" 新增 ")])), _: 1, __: [0] }, 8, ["onClick"])), [[U, e(d).add]])])]), default: i(() => [v((n(), r(D, { ref_key: "tableRef", ref: g, data: e(l).data, "empty-text": e(l).emptyText, "max-height": e(E), style: { width: "100%" } }, { default: i(() => [s(p, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(S).visible("name") ? (n(), r(p, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "分包类别", "min-width": "150" }, { default: i((o) => [o.row.edit ? (n(), r(N, { key: 0, modelValue: o.row.name, "onUpdate:modelValue": (m) => o.row.name = m, type: "text", placeholder: "分包类别", style: { width: "260px" }, maxlength: "50" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), _("div", J, F(o.row.name), 1))]), _: 1 })) : u("", true), e(C)([...e(d).del, ...e(d).edit]) ? (n(), r(p, { key: 1, label: "操作", width: "150px", align: "center", fixed: "right" }, { default: i((o) => [o.row.edit ? (n(), _(x, { key: 0 }, [s(c, { type: "info", size: "default", onClick: (m) => I(o.row) }, { default: i(() => t[2] || (t[2] = [y("取消")])), _: 2, __: [2] }, 1032, ["onClick"]), s(c, { type: "primary", size: "default", onClick: (m) => T(o.row) }, { default: i(() => t[3] || (t[3] = [y("保存")])), _: 2, __: [3] }, 1032, ["onClick"])], 64)) : (n(), _(x, { key: 1 }, [e(C)(e(d).edit) && o.row.name !== "劳务分包" ? (n(), r(c, { key: 0, size: "default", icon: "el-icon-edit", type: "primary", onClick: (m) => o.row.edit = true }, null, 8, ["onClick"])) : u("", true), e(C)(e(d).del) && o.row.name !== "劳务分包" ? (n(), r(R, { key: 1, "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定删除吗?", onConfirm: (m) => V(o.row) }, { reference: i(() => [s(c, { size: "default", icon: "el-icon-delete", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])) : u("", true)], 64))]), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[z, e(l).loading]])]), _: 1 }), f("div", K, [s(e(Q))])], 64);
  };
} }, ne = q(X, [["__scopeId", "data-v-66d65998"]]);
export {
  ne as default
};
