import { useStore as j } from "vuex";
import { ref as q } from "vue";
import { inject as M } from "vue";
import { computed as Q } from "vue";
import { watch as W } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as l } from "vue";
import { createBlock as i } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as V } from "vue";
import { unref as e } from "vue";
import { createTextVNode as O } from "vue";
import { createCommentVNode as c } from "vue";
import { withDirectives as w } from "vue";
import { vShow as I } from "vue";
import { createVNode as r } from "vue";
import { ElMessageBox as $ } from "element-plus";
import { ElTag as z } from "element-plus";
import { ElTableColumn as G } from "element-plus";
import { InfoFilled as Y } from "@element-plus/icons-vue";
import { ElIcon as J } from "element-plus";
import { ElTooltip as X } from "element-plus";
import { ElSwitch as Z } from "element-plus";
import { ElCard as ee } from "element-plus";
import { vLoading as te } from "element-plus";
import { l as h, _ as oe, x as ae, b9 as b, G as x, aS as u, an as ne, P as le } from "../../../../../shared/runtime.js";
import ie from "./module/header.vue.js";
import re from "./module/form.vue.js";
function de(t) {
  return h({ module: "bridge", url: "workshop/page", method: "get", params: t });
}
function se(t) {
  return h({ module: "bridge", url: "workshop", method: "post", data: t });
}
function ce(t) {
  return h({ module: "bridge", url: "workshop", method: "put", data: t });
}
function ue({ id: t, boolEnabledEnum: g }) {
  return h({ module: "bridge", url: "workshop/changeState", method: "put", data: { id: t, boolEnabledEnum: g } });
}
function me(t) {
  return h({ module: "bridge", url: "workshop", method: "delete", data: { ids: t } });
}
const pe = { get: de, add: se, edit: ce, del: me };
const fe = { style: { "line-height": "1.7" } }, _e = { class: "head-container" }, be = { style: { display: "inline-block" } }, he = { __name: "index", props: { factory: { type: Object, default: () => {
} } }, setup(t) {
  const g = j(), D = { add: false, edit: false, del: false, download: false }, k = q(), { crud: o, columns: y, CRUD: _ } = ae({ title: "车间", sort: [], permission: { ...b }, optShow: { ...D }, crudApi: { ...pe }, queryOnPresenterCreated: false }, k), F = M("maxHeight"), S = t, m = Q(() => S.factory && S.factory.id);
  W(() => m, (d) => {
    d.value && o.toQuery();
  }, { deep: true, immediate: true });
  async function U(d, a) {
    try {
      await $.confirm('此操作将 "' + u.VL[a] + '" ' + d.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await ue({ id: d.id, boolEnabledEnum: a }), o.refresh(), o.notify(u.VL[a] + "成功", _.NOTIFICATION_TYPE.SUCCESS), E();
    } catch (v) {
      console.log("变更车间状态", v), d.boolEnabledEnum = d.boolEnabledEnum === u.TRUE.V ? u.FALSE.V : u.TRUE.V;
    }
  }
  _.HOOK.beforeToQuery = () => {
    o.query.factoryId = m.value;
  }, _.HOOK.beforeSubmit = () => {
    o.form.factoryId = m.value;
  }, _.HOOK.afterSubmit = () => {
    E();
  }, _.HOOK.afterDelete = () => {
    E();
  };
  function E() {
    g.commit("config/SET_LOADED", { key: "bridgeWorkshops", loaded: false });
  }
  return (d, a) => {
    const v = z, A = T("common-button"), p = G, B = Y, L = J, R = X, H = Z, N = T("common-table"), P = ee, K = te;
    return l(), i(P, null, { header: n(() => [s("span", fe, V(e(o).title) + "列表 ", 1), t.factory && t.factory.name ? (l(), i(v, { key: 0, type: "success" }, { default: n(() => [O(V(t.factory.name), 1)]), _: 1 })) : c("", true), e(x)(e(b).add) ? (l(), i(A, { key: 1, disabled: !m.value, class: "filter-item", style: { float: "right", padding: "6px 10px" }, size: "default", type: "primary", icon: "el-icon-plus", onClick: e(o).toAdd }, { default: n(() => a[0] || (a[0] = [O(" 新增 ")])), _: 1, __: [0] }, 8, ["disabled", "onClick"])) : c("", true)]), default: n(() => [w(s("div", null, a[1] || (a[1] = [s("div", { class: "my-code" }, "点击工厂查看详情", -1)]), 512), [[I, !m.value]]), w(s("div", null, [s("div", _e, [r(e(ie))]), w((l(), i(N, { ref_key: "tableRef", ref: k, data: e(o).data, "empty-text": e(o).emptyText, "max-height": e(F), style: { width: "100%" } }, { default: n(() => [r(p, { label: "序号", type: "index", align: "center", width: "60" }), e(y).visible("name") ? (l(), i(p, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "车间名称", "min-width": "140px" })) : c("", true), e(y).visible("boolEnabledEnum") ? (l(), i(p, { key: "boolEnabledEnum", prop: "boolEnabledEnum", label: "状态", align: "center", width: "80px" }, { header: n(() => [r(R, { class: "item", effect: "light", content: "车间被禁用后，该车间无法再在其它页面中显示", placement: "top" }, { default: n(() => [s("div", be, [a[2] || (a[2] = s("span", null, "状态", -1)), r(L, null, { default: n(() => [r(B)]), _: 1 })])]), _: 1 })]), default: n((f) => [r(H, { modelValue: f.row.boolEnabledEnum, "onUpdate:modelValue": (C) => f.row.boolEnabledEnum = C, disabled: !e(x)(e(b).editStatus), "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(u).TRUE.V, "inactive-value": e(u).FALSE.V, onChange: (C) => U(f.row, f.row.boolEnabledEnum) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])]), _: 1 })) : c("", true), e(y).visible("sort") ? (l(), i(p, { key: "sort", prop: "sort", label: "排序", align: "center", width: "80px" })) : c("", true), e(y).visible("remark") ? (l(), i(p, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "160px" })) : c("", true), e(x)([...e(b).del, ...e(b).edit]) ? (l(), i(p, { key: 4, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: n((f) => [r(e(ne), { data: f.row }, null, 8, ["data"])]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[K, e(o).loading]]), r(e(le))], 512), [[I, m.value]]), r(e(re))]), _: 1 });
  };
} }, we = oe(he, [["__scopeId", "data-v-202598e1"]]);
export {
  we as default
};
