import { ref as b } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as r } from "vue";
import { createBlock as v } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as k } from "vue";
import { createVNode as a } from "vue";
import { unref as n } from "vue";
import { createTextVNode as T } from "vue";
import { withDirectives as $ } from "vue";
import { createElementBlock as m } from "vue";
import { toDisplayString as g } from "vue";
import { withModifiers as j } from "vue";
import { isRef as I } from "vue";
import { ElMessage as Q } from "element-plus";
import { ElTableColumn as U } from "element-plus";
import { ElPopconfirm as F } from "element-plus";
import { vLoading as O } from "element-plus";
import { l as h, _ as G, u as J, x as K, o as W } from "../../../../../shared/runtime.js";
import X from "./module/form.vue.js";
import "../../../../../modules/stud-set-1d850c87.js";
import "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
import "../../../../../modules/use-production-team-d8043fd6.js";
function Y(i) {
  return h({ module: "mes", url: "quota-config/production-reporting-approval-whitelist/list", method: "get", params: i });
}
function C(i) {
  return h({ module: "mes", url: "quota-config/production-reporting-approval-whitelist/add-or-edit", method: "post", data: i });
}
function Z(i) {
  return h({ module: "mes", url: `quota-config/production-reporting-approval-whitelist/${i}`, method: "delete" });
}
const L = { get: Y, add: C, edit: C, del: Z };
const ee = { key: 0 }, te = { key: 1 }, oe = { key: 0 }, ae = { key: 1 }, ne = { __name: "index", props: { modelValue: { type: Boolean, default: false }, data: { type: Array, default: () => [] }, reviewStatus: { type: [String, Number], default: null } }, emits: ["update:modelValue"], setup(i, { emit: V }) {
  const B = V, H = i, { visible: u, handleClose: R } = J({ emit: B, props: H, showHook: A, closeHook: D }), E = b(), y = b(), { crud: l } = K({ title: "白名单配置", sort: [], crudApi: { ...L }, dataPath: "", queryOnPresenterCreated: false, hasPagination: false }, E), { maxHeight: q } = W({ mainBox: ".white-list-config", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", navbar: false, clientHRepMainH: true, minHeight: 300 }, () => y.value.loaded);
  function A() {
    l.toQuery();
  }
  async function z(x) {
    try {
      await L.del(x.id), Q({ message: "删除成功", type: "success" }), l.toQuery();
    } catch (s) {
      console.log("删除失败", s);
    }
  }
  function D() {
  }
  return (x, s) => {
    const _ = w("common-button"), c = U, M = F, N = w("common-table"), P = w("common-drawer"), S = O;
    return r(), v(P, { ref_key: "drawerRef", ref: y, "append-to-body": "", modelValue: n(u), "onUpdate:modelValue": s[0] || (s[0] = (e) => I(u) ? u.value = e : null), "before-close": n(R), "close-on-click-modal": false, title: "白名单设置", size: "40%", "custom-class": "white-list-config" }, { titleAfter: o(() => s[1] || (s[1] = [k("span", { class: "tips" }, "*添加到此页的班组，将无需进行人工审核，由系统自动审核。", -1)])), titleRight: o(() => [a(_, { type: "success", size: "default", onClick: n(l).toAdd }, { default: o(() => s[2] || (s[2] = [T(" 创建 ")])), _: 1, __: [2] }, 8, ["onClick"])]), content: o(() => [$((r(), v(N, { data: n(l).data, "empty-text": n(l).emptyText, "max-height": n(q), "return-source-data": "", showEmptySymbol: false }, { default: o(() => [a(c, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), a(c, { key: "workshopList", prop: "workshopList", "show-overflow-tooltip": "", label: "车间", align: "center" }, { default: o((e) => {
      var t, d, p;
      return [(t = e.row.workshopList) != null && t.length ? (r(), m("span", ee, g((p = (d = e.row.workshopList) == null ? void 0 : d.map((f) => f.name)) == null ? void 0 : p.join("、")), 1)) : (r(), m("span", te, "-"))];
    }), _: 1 }), a(c, { key: "process", prop: "process", "show-overflow-tooltip": "", label: "工序", align: "center" }, { default: o((e) => {
      var t;
      return [k("span", null, g(((t = e.row.process) == null ? void 0 : t.name) || "-"), 1)];
    }), _: 1 }), a(c, { key: "teamList", prop: "teamList", "show-overflow-tooltip": "", label: "班组", align: "center" }, { default: o((e) => {
      var t, d, p;
      return [(t = e.row.teamList) != null && t.length ? (r(), m("span", oe, g((p = (d = e.row.teamList) == null ? void 0 : d.map((f) => f.name)) == null ? void 0 : p.join("、")), 1)) : (r(), m("span", ae, "-"))];
    }), _: 1 }), a(c, { key: "teamList", prop: "outboundTime", "show-overflow-tooltip": "", label: "操作", align: "center" }, { default: o((e) => [a(_, { icon: "el-icon-edit", size: "default", type: "primary", onClick: j((t) => n(l).toEdit(e.row), ["stop"]) }, null, 8, ["onClick"]), a(M, { "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定删除吗?", onConfirm: (t) => z(e.row) }, { reference: o(() => [a(_, { icon: "el-icon-delete", type: "danger", size: "default" })]), _: 2 }, 1032, ["onConfirm"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[S, n(l).loading]]), a(n(X))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ue = G(ne, [["__scopeId", "data-v-2d8d1cc2"]]);
export {
  ue as default
};
