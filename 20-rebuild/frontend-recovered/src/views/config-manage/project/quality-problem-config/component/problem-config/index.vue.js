import { ref as A } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as s } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as f } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as r } from "vue";
import { unref as e } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as F } from "vue";
import { createCommentVNode as p } from "vue";
import { Fragment as x } from "vue";
import { ElMessage as O } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { ElInput as H } from "element-plus";
import { ElPopconfirm as M } from "element-plus";
import { ElCard as j } from "element-plus";
import { vLoading as q } from "element-plus";
import { _ as Y, x as G, fI as d, fJ as C, o as J, G as g } from "../../../../../../shared/runtime.js";
import L from "./module/form.vue.js";
const Q = { class: "clearfix" }, K = { key: 1 }, W = { class: "app-container" }, X = { __name: "index", setup(Z) {
  const v = { add: true, edit: false, del: false, download: false }, w = A(), { crud: l, CRUD: b, columns: S } = G({ title: "问题分类", sort: [], permission: { ...d }, optShow: { ...v }, crudApi: { ...C }, hasPagination: false }, w), { maxHeight: E } = J({ wrapperBox: ".qualityProblemConfig", paginate: true, extraHeight: 40 });
  async function I(a) {
    if (!a.name) {
      O.error("请填写问题分类");
      return;
    }
    try {
      await C.edit(a), l.notify("修改成功", b.NOTIFICATION_TYPE.SUCCESS), a.edit = false;
    } catch (t) {
      console.log("问题分类", t);
    }
  }
  async function T(a) {
    try {
      await C.del([a.id]), l.notify("删除成功", b.NOTIFICATION_TYPE.SUCCESS), l.toQuery();
    } catch (t) {
      console.log("删除", t);
    }
  }
  function N(a) {
    a.name = a.sourceRow.name, a.edit = false;
  }
  return (a, t) => {
    const c = h("common-button"), u = $, P = H, V = M, R = h("common-table"), D = j, U = B("permission"), z = q;
    return o(), _(x, null, [s(D, { shadow: "always" }, { header: i(() => [f("div", Q, [t[1] || (t[1] = f("span", { class: "card-title" }, "问题分类", -1)), k((o(), r(c, { size: "default", type: "primary", style: { float: "right" }, onClick: e(l).toAdd }, { default: i(() => t[0] || (t[0] = [y(" 新增 ")])), _: 1, __: [0] }, 8, ["onClick"])), [[U, e(d).add]])])]), default: i(() => [k((o(), r(R, { ref_key: "tableRef", ref: w, data: e(l).data, "empty-text": e(l).emptyText, "max-height": e(E), style: { width: "100%" } }, { default: i(() => [s(u, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(S).visible("name") ? (o(), r(u, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "问题分类", "min-width": "150" }, { default: i((n) => [n.row.edit ? (o(), r(P, { key: 0, modelValue: n.row.name, "onUpdate:modelValue": (m) => n.row.name = m, type: "text", placeholder: "问题分类", style: { width: "260px" }, maxlength: "50" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), _("div", K, F(n.row.name), 1))]), _: 1 })) : p("", true), e(g)([...e(d).del, ...e(d).edit]) ? (o(), r(u, { key: 1, label: "操作", width: "150px", align: "center", fixed: "right" }, { default: i((n) => [n.row.edit ? (o(), _(x, { key: 0 }, [s(c, { type: "info", size: "default", onClick: (m) => N(n.row) }, { default: i(() => t[2] || (t[2] = [y("取消")])), _: 2, __: [2] }, 1032, ["onClick"]), s(c, { type: "primary", size: "default", onClick: (m) => I(n.row) }, { default: i(() => t[3] || (t[3] = [y("保存")])), _: 2, __: [3] }, 1032, ["onClick"])], 64)) : (o(), _(x, { key: 1 }, [e(g)(e(d).edit) ? (o(), r(c, { key: 0, size: "default", icon: "el-icon-edit", type: "primary", onClick: (m) => n.row.edit = true }, null, 8, ["onClick"])) : p("", true), e(g)(e(d).del) ? (o(), r(V, { key: 1, "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定删除吗?", onConfirm: (m) => T(n.row) }, { reference: i(() => [s(c, { size: "default", icon: "el-icon-delete", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])) : p("", true)], 64))]), _: 1 })) : p("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[z, e(l).loading]])]), _: 1 }), f("div", W, [s(e(L))])], 64);
  };
} }, ae = Y(X, [["__scopeId", "data-v-ebbcfd93"]]);
export {
  ae as default
};
