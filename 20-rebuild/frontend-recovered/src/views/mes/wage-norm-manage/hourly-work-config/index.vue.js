import { ref as N } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as f } from "vue";
import { unref as e } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as i } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as r } from "vue";
import { toDisplayString as k } from "vue";
import { withModifiers as x } from "vue";
import { ElMessageBox as C } from "element-plus";
import { ElMessage as M } from "element-plus";
import { ElTableColumn as P } from "element-plus";
import { ElSwitch as R } from "element-plus";
import { vLoading as $ } from "element-plus";
import { l as d, x as I, sc as w, o as z, sd as H, bV as O, D as W, aS as h, G as _ } from "../../../../shared/runtime.js";
import Y from "./module/header.vue.js";
import G from "./module/form.vue.js";
function j(o) {
  return d({ module: "mes", url: "wage-quota/temp-work-quota-config/list", method: "get", params: o });
}
function J(o) {
  return d({ module: "mes", url: "wage-quota/temp-work-quota-config", method: "post", data: o });
}
function K(o) {
  return d({ module: "mes", url: "wage-quota/temp-work-quota-config", method: "put", data: o });
}
function Q(o) {
  return d({ module: "mes", url: "wage-quota/temp-work-quota-config", method: "delete", params: o });
}
function X(o) {
  return d({ module: "mes", url: "wage-quota/temp-work-quota-config/status", method: "put", params: o });
}
const E = { get: j, del: Q, add: J, edit: K }, Z = { class: "app-container" }, ee = { class: "head-container" }, se = { __name: "index", setup(o) {
  const V = { add: true, edit: false, del: false, download: false }, y = N(), { crud: s, columns: m, CRUD: T } = I({ title: "点工配置", permission: { ...w }, optShow: { ...V }, crudApi: { ...E }, sort: [], hasPagination: false }, y), { maxHeight: q } = z({ paginate: false });
  async function S(l, c) {
    try {
      await C.confirm('此操作将 "' + h.VL[c] + '" ' + l.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const a = { id: l.id, status: l.status };
      await X(a), s.refresh(), s.notify(h.VL[c] + "成功", T.NOTIFICATION_TYPE.SUCCESS);
    } catch (a) {
      console.log("变更用户状态", a), l.status = !c;
    }
  }
  async function B(l) {
    try {
      await C.confirm("确认删除该配置？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await E.del({ id: l.id }), M.success("删除成功！"), s.refresh();
    } catch (c) {
      console.log(c);
    }
  }
  return (l, c) => {
    const a = P, D = R, v = b("common-button"), U = b("common-table"), F = $;
    return n(), A("div", Z, [g("div", ee, [f(e(Y))]), L((n(), i(U, { ref_key: "tableRef", ref: y, data: e(s).data, "empty-text": e(s).emptyText, "max-height": e(q), style: { width: "100%" } }, { default: u(() => [f(a, { label: "序号", type: "index", align: "center", width: "60" }), e(m).visible("name") ? (n(), i(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "点工类型", align: "center", "min-width": "100px" })) : r("", true), e(m).visible("type") ? (n(), i(a, { key: "type", prop: "type", "show-overflow-tooltip": true, label: "类型", align: "center", "min-width": "100px" }, { default: u((t) => [g("span", null, k(e(H).VL[t.row.type] || "-"), 1)]), _: 1 })) : r("", true), e(m).visible("price") ? (n(), i(a, { key: "price", prop: "price", "show-overflow-tooltip": true, label: "工时单价（元/小时）", align: "center", "min-width": "100px" }, { default: u((t) => [g("span", null, k(e(O)(t.row.price, e(W).YUAN) || "-"), 1)]), _: 1 })) : r("", true), e(m).visible("status") ? (n(), i(a, { key: "status", prop: "status", label: "状态", align: "center" }, { default: u((t) => [t.row.id ? (n(), i(D, { key: 0, modelValue: t.row.status, "onUpdate:modelValue": (p) => t.row.status = p, "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(h).TRUE.V, "inactive-value": e(h).FALSE.V, disabled: !e(_)(e(w).status), onChange: (p) => S(t.row, t.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "disabled", "onChange"])) : r("", true)]), _: 1 })) : r("", true), f(a, { label: "操作", width: "130px", align: "center", fixed: "right" }, { default: u((t) => [e(_)(e(w).edit) ? (n(), i(v, { key: 0, icon: "el-icon-edit", size: "default", type: "primary", onClick: x((p) => e(s).toEdit(t.row), ["stop"]) }, null, 8, ["onClick"])) : r("", true), e(_)(e(w).del) ? (n(), i(v, { key: 1, icon: "el-icon-delete", size: "default", type: "danger", onClick: x((p) => B(t.row), ["stop"]) }, null, 8, ["onClick"])) : r("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[F, e(s).loading]]), f(e(G))]);
  };
} };
export {
  se as default
};
