import { useStore as K } from "vuex";
import { ref as j } from "vue";
import { inject as q } from "vue";
import { computed as M } from "vue";
import { watch as Q } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as n } from "vue";
import { createBlock as l } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as C } from "vue";
import { unref as e } from "vue";
import { createTextVNode as T } from "vue";
import { createCommentVNode as d } from "vue";
import { withDirectives as v } from "vue";
import { vShow as V } from "vue";
import { createVNode as i } from "vue";
import { ElMessageBox as $ } from "element-plus";
import { ElTag as z } from "element-plus";
import { ElTableColumn as G } from "element-plus";
import { InfoFilled as W } from "@element-plus/icons-vue";
import { ElIcon as Y } from "element-plus";
import { ElTooltip as J } from "element-plus";
import { ElSwitch as X } from "element-plus";
import { ElCard as Z } from "element-plus";
import { vLoading as ee } from "element-plus";
import { c as te, e as oe } from "../../../../../modules/workshop-e9af8725.js";
import { _ as ae, x as ne, oP as _, G as g, aS as c, an as le, P as ie } from "../../../../../shared/runtime.js";
import se from "./module/header.vue.js";
import re from "./module/form.vue.js";
const de = { style: { "line-height": "1.7" } }, ce = { class: "head-container" }, ue = { style: { display: "inline-block" } }, me = { __name: "index", props: { factory: { type: Object, default: () => {
} } }, setup(b) {
  const O = K(), I = { add: false, edit: false, del: false, download: false }, w = j(), { crud: t, columns: y, CRUD: p } = ne({ title: "车间", sort: [], permission: { ..._ }, optShow: { ...I }, crudApi: { ...te }, queryOnPresenterCreated: false }, w), D = q("maxHeight"), x = b, u = M(() => x.factory && x.factory.id);
  Q(() => u, (s) => {
    s.value && t.toQuery();
  }, { deep: true, immediate: true });
  async function F(s, o) {
    try {
      await $.confirm('此操作将 "' + c.VL[o] + '" ' + s.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await oe({ id: s.id, boolEnabledEnum: o }), t.refresh(), t.notify(c.VL[o] + "成功", p.NOTIFICATION_TYPE.SUCCESS), h();
    } catch (E) {
      console.log("变更车间状态", E), s.boolEnabledEnum = s.boolEnabledEnum === c.TRUE.V ? c.FALSE.V : c.TRUE.V;
    }
  }
  p.HOOK.beforeToQuery = () => {
    t.query.factoryId = u.value;
  }, p.HOOK.beforeSubmit = () => {
    t.form.factoryId = u.value;
  }, p.HOOK.afterSubmit = () => {
    h();
  }, p.HOOK.afterDelete = () => {
    h();
  };
  function h() {
    O.commit("config/SET_LOADED", { key: "workshops", loaded: false });
  }
  return (s, o) => {
    const E = z, U = S("common-button"), m = G, A = W, B = Y, L = J, P = X, R = S("common-table"), H = Z, N = ee;
    return n(), l(H, null, { header: a(() => [r("span", de, C(e(t).title) + "列表 ", 1), b.factory && b.factory.name ? (n(), l(E, { key: 0, type: "success" }, { default: a(() => [T(C(b.factory.name), 1)]), _: 1 })) : d("", true), e(g)(e(_).add) ? (n(), l(U, { key: 1, disabled: !u.value, class: "filter-item", style: { float: "right", padding: "6px 10px" }, size: "default", type: "primary", icon: "el-icon-plus", onClick: e(t).toAdd }, { default: a(() => o[0] || (o[0] = [T(" 新增 ")])), _: 1, __: [0] }, 8, ["disabled", "onClick"])) : d("", true)]), default: a(() => [v(r("div", null, o[1] || (o[1] = [r("div", { class: "my-code" }, "点击工厂查看详情", -1)]), 512), [[V, !u.value]]), v(r("div", null, [r("div", ce, [i(e(se))]), v((n(), l(R, { ref_key: "tableRef", ref: w, data: e(t).data, "empty-text": e(t).emptyText, "max-height": e(D), style: { width: "100%" } }, { default: a(() => [i(m, { label: "序号", type: "index", align: "center", width: "60" }), e(y).visible("name") ? (n(), l(m, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "车间名称", "min-width": "140px" })) : d("", true), e(y).visible("boolEnabledEnum") ? (n(), l(m, { key: "boolEnabledEnum", prop: "boolEnabledEnum", label: "状态", align: "center", width: "80px" }, { header: a(() => [i(L, { class: "item", effect: "light", content: "车间被禁用后，该车间无法再在其它页面中显示", placement: "top" }, { default: a(() => [r("div", ue, [o[2] || (o[2] = r("span", null, "状态", -1)), i(B, null, { default: a(() => [i(A)]), _: 1 })])]), _: 1 })]), default: a((f) => [i(P, { modelValue: f.row.boolEnabledEnum, "onUpdate:modelValue": (k) => f.row.boolEnabledEnum = k, disabled: !e(g)(e(_).editStatus), "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(c).TRUE.V, "inactive-value": e(c).FALSE.V, onChange: (k) => F(f.row, f.row.boolEnabledEnum) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])]), _: 1 })) : d("", true), e(y).visible("sort") ? (n(), l(m, { key: "sort", prop: "sort", label: "排序", align: "center", width: "80px" })) : d("", true), e(y).visible("remark") ? (n(), l(m, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "160px" })) : d("", true), e(g)([...e(_).del, ...e(_).edit]) ? (n(), l(m, { key: 4, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: a((f) => [i(e(le), { data: f.row }, null, 8, ["data"])]), _: 1 })) : d("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[N, e(t).loading]]), i(e(ie))], 512), [[V, u.value]]), i(e(re))]), _: 1 });
  };
} }, he = ae(me, [["__scopeId", "data-v-28d3d9f1"]]);
export {
  he as default
};
