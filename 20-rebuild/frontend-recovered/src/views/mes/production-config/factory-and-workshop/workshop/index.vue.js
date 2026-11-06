import { useStore as K } from "vuex";
import { ref as j } from "vue";
import { inject as q } from "vue";
import { computed as M } from "vue";
import { watch as Q } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as t } from "vue";
import { createBlock as o } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as c } from "vue";
import { toDisplayString as E } from "vue";
import { unref as e } from "vue";
import { createTextVNode as T } from "vue";
import { createCommentVNode as i } from "vue";
import { withDirectives as g } from "vue";
import { vShow as V } from "vue";
import { createVNode as s } from "vue";
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
import { _ as ae, x as le, oP as h, G as x, fa as ne, aS as u, an as ie, P as se } from "../../../../../shared/runtime.js";
import re from "./module/header.vue.js";
import de from "./module/form.vue.js";
const ce = { style: { "line-height": "1.7" } }, me = { class: "head-container" }, ue = { style: { display: "inline-block" } }, pe = { __name: "index", props: { factory: { type: Object, default: () => {
} } }, setup(y) {
  const O = K(), N = { add: false, edit: false, del: false, download: false }, k = j(), { crud: l, columns: p, CRUD: _ } = le({ title: "车间", sort: [], permission: { ...h }, optShow: { ...N }, crudApi: { ...te }, queryOnPresenterCreated: false }, k), I = q("maxHeight"), S = y, f = M(() => S.factory && S.factory.id);
  Q(() => f, (m) => {
    m.value && l.toQuery();
  }, { deep: true, immediate: true });
  async function D(m, n) {
    try {
      await $.confirm('此操作将 "' + u.VL[n] + '" ' + m.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await oe({ id: m.id, boolEnabledEnum: n }), l.refresh(), l.notify(u.VL[n] + "成功", _.NOTIFICATION_TYPE.SUCCESS), v();
    } catch (w) {
      console.log("变更车间状态", w), m.boolEnabledEnum = m.boolEnabledEnum === u.TRUE.V ? u.FALSE.V : u.TRUE.V;
    }
  }
  _.HOOK.beforeToQuery = () => {
    l.query.factoryId = f.value;
  }, _.HOOK.beforeSubmit = () => {
    l.form.factoryId = f.value;
  }, _.HOOK.afterSubmit = () => {
    v();
  }, _.HOOK.afterDelete = () => {
    v();
  };
  function v() {
    O.commit("config/SET_LOADED", { key: "workshops", loaded: false });
  }
  return (m, n) => {
    const w = z, F = C("common-button"), r = G, L = W, U = Y, A = J, B = X, P = C("common-table"), R = Z, H = ee;
    return t(), o(R, null, { header: a(() => [c("span", ce, E(e(l).title) + "列表 ", 1), y.factory && y.factory.name ? (t(), o(w, { key: 0, type: "success" }, { default: a(() => [T(E(y.factory.name), 1)]), _: 1 })) : i("", true), e(x)(e(h).add) ? (t(), o(F, { key: 1, disabled: !f.value, class: "filter-item", style: { float: "right", padding: "6px 10px" }, size: "default", type: "primary", icon: "el-icon-plus", onClick: e(l).toAdd }, { default: a(() => n[0] || (n[0] = [T(" 新增 ")])), _: 1, __: [0] }, 8, ["disabled", "onClick"])) : i("", true)]), default: a(() => [g(c("div", null, n[1] || (n[1] = [c("div", { class: "my-code" }, "点击工厂查看详情", -1)]), 512), [[V, !f.value]]), g(c("div", null, [c("div", me, [s(e(re))]), g((t(), o(P, { ref_key: "tableRef", ref: k, data: e(l).data, "empty-text": e(l).emptyText, "max-height": e(I), style: { width: "100%" } }, { default: a(() => [s(r, { label: "序号", type: "index", align: "center", width: "60" }), e(p).visible("name") ? (t(), o(r, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "车间名称", "min-width": "140px" })) : i("", true), e(p).visible("shortName") ? (t(), o(r, { key: "shortName", prop: "shortName", "show-overflow-tooltip": true, label: "车间简称", "min-width": "100px" })) : i("", true), e(p).visible("shortName") ? (t(), o(r, { key: "shortName", prop: "shortName", "show-overflow-tooltip": true, label: "车间类型", align: "center", width: "80px" }, { default: a(({ row: d }) => {
      var b;
      return [c("span", null, E((b = e(ne).VL) == null ? void 0 : b[d.type]), 1)];
    }), _: 1 })) : i("", true), e(p).visible("boolEnabledEnum") ? (t(), o(r, { key: "boolEnabledEnum", prop: "boolEnabledEnum", label: "状态", align: "center", width: "80px" }, { header: a(() => [s(A, { class: "item", effect: "light", content: "车间被禁用后，该车间无法再在其它页面中显示", placement: "top" }, { default: a(() => [c("div", ue, [n[2] || (n[2] = c("span", null, "状态", -1)), s(U, null, { default: a(() => [s(L)]), _: 1 })])]), _: 1 })]), default: a((d) => [s(B, { modelValue: d.row.boolEnabledEnum, "onUpdate:modelValue": (b) => d.row.boolEnabledEnum = b, disabled: !e(x)(e(h).editStatus), "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(u).TRUE.V, "inactive-value": e(u).FALSE.V, onChange: (b) => D(d.row, d.row.boolEnabledEnum) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])]), _: 1 })) : i("", true), e(p).visible("sort") ? (t(), o(r, { key: "sort", prop: "sort", label: "排序", align: "center", width: "80px" })) : i("", true), e(p).visible("remark") ? (t(), o(r, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "160px" })) : i("", true), e(x)([...e(h).del, ...e(h).edit]) ? (t(), o(r, { key: 6, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: a((d) => [s(e(ie), { data: d.row }, null, 8, ["data"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[H, e(l).loading]]), s(e(se))], 512), [[V, f.value]]), s(e(de))]), _: 1 });
  };
} }, ve = ae(pe, [["__scopeId", "data-v-c0bcab08"]]);
export {
  ve as default
};
