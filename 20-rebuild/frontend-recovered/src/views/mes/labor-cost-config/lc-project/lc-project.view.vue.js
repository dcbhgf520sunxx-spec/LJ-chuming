import { l as O, e2 as L, _ as z, x as I, ct as K, ez as N, P as A, j0 as H } from "../../../../shared/runtime.js";
import { ref as h } from "vue";
import { watch as Q } from "vue";
import { watchEffect as $ } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as l } from "vue";
import { unref as a } from "vue";
import { isRef as w } from "vue";
import { ElInput as q } from "element-plus";
import { withCtx as g } from "vue";
import { Fragment as J } from "vue";
import { renderList as F } from "vue";
import { toDisplayString as G } from "vue";
import { withDirectives as W } from "vue";
import { createBlock as m } from "vue";
import { createCommentVNode as f } from "vue";
import { ElDatePicker as S } from "element-plus";
import { normalizeStyle as X } from "vue";
import { withModifiers as Y } from "vue";
import { ElRadioButton as Z } from "element-plus";
import { ElRadioGroup as ee } from "element-plus";
import { ElTableColumn as te } from "element-plus";
import { ElButton as ae } from "element-plus";
import { vLoading as ie } from "element-plus";
const ne = (d) => O({ method: "get", url: "/api/system/contract-project-statistics-config-link/page", params: d, cancelKey: false }), le = (d) => O({ method: "put", url: `
				api
				/system
				/contract-project-statistics-config-link
			`, data: d, cancelKey: false }), oe = { get: ne }, se = (d, _) => {
  const t = JSON.parse(JSON.stringify(d));
  t.statisticsDeadline = new Date(t.statisticsDeadline).getTime(), t.configurePriceDate = (t.configurePriceDate ?? []).map((o) => o ? new Date(o).getTime() : ""), t.signelPriceDate = (t.signelPriceDate ?? []).map((o) => o ? new Date(o).getTime() : "");
  const P = { configPriceSyncEndDate: t.configurePriceDate[0] ?? "", configPriceSyncStartDate: t.configurePriceDate[1] ?? "", individualPriceSyncEndDate: t.signelPriceDate[0] ?? "", individualPriceSyncStartDate: t.signelPriceDate[1] ?? "" };
  delete t.configurePriceDate, delete t.signelPriceDate, delete t.options, delete t.configPriceName, delete t.createTime, delete t.individualPriceName, delete t.projectName, delete t.statisticsModeName, delete t.updateTime, le(Object.assign(t, P)).then(() => {
    L("success", "操作成功"), _();
  }).catch((o) => {
    console.log(o);
  });
}, x = (d, _) => d.filter((t) => _ && _ !== "" ? t.projectName.includes(_) : true), ce = Object.freeze(Object.defineProperty({ __proto__: null, filter: x, save: se }, Symbol.toStringTag, { value: "Module" }));
const de = { class: "app-container" }, re = { class: "header" }, ue = { class: "search-container" }, pe = { class: "radio-container" }, me = { class: "content" }, _e = { class: "screen" }, ge = { class: "screen" }, fe = { __name: "lc-project.view", setup(d) {
  const _ = [], t = ["实时计算模式", "入库倒推模式"], [P, o, b, y] = [h(), h(), h(), h(2)], { crud: D, columns: v, CRUD: V } = I({ sort: [], title: "项目工价", hasPagination: true, permission: { ...K }, crudApi: { ...oe } }, P);
  Q(y, () => D.toQuery());
  const M = async (r) => {
    await H(() => Promise.resolve().then(() => ce), void 0).then((u) => u.save(r, D.toQuery));
  };
  V.HOOK.beforeToQuery = (r) => {
    r.query = { statisticsMode: y.value };
  }, V.HOOK.handleRefresh = (r, u) => {
    const E = u.data.content.map((n) => {
      const c = { configurePriceDate: [n.configPriceSyncStartDate, n.configPriceSyncEndDate], signelPriceDate: [n.individualPriceSyncStartDate, n.individualPriceSyncEndDate] };
      return delete n.configPriceSyncEndDate, delete n.configPriceSyncStartDate, delete n.individualPriceSyncStartDate, delete n.individualPriceSyncEndDate, n.isEditing = false, Object.assign(n, c);
    });
    $(() => o.value = x(E, b.value));
  };
  const T = (r) => {
    r.isEditing = !r.isEditing;
  };
  return (r, u) => {
    const E = Z, n = ee, c = te, k = U("common-select"), j = ae, R = U("common-table"), B = ie;
    return s(), C("div", de, [p("div", re, [p("div", ue, [l(a(q), { modelValue: a(b), "onUpdate:modelValue": u[0] || (u[0] = (e) => w(b) ? b.value = e : null), placeholder: "请输入搜索关键字", clearable: "", "suffix-icon": "el-icon-search" }, null, 8, ["modelValue"])]), p("div", pe, [l(n, { modelValue: a(y), "onUpdate:modelValue": u[1] || (u[1] = (e) => w(y) ? y.value = e : null) }, { default: g(() => [(s(), C(J, null, F(t, (e, i) => l(E, { key: i + 1, value: i + 1, disabled: i === 0 }, { default: g(() => [p("span", null, G(e), 1)]), _: 2 }, 1032, ["value", "disabled"])), 64))]), _: 1 }, 8, ["modelValue"])])]), p("div", me, [W((s(), m(R, { ref_key: "tableRef", ref: P, data: a(o), "data-format": _, "empty-text": a(D).emptyText, "max-height": "700px", "return-source-data": "", style: { width: "100%" } }, { default: g(() => [l(c, { label: "序号", align: "center", type: "index" }), a(v).visible("projectName") ? (s(), m(c, { key: "projectName", prop: "projectName", "show-overflow-tooltip": "", label: "项目名称", align: "center" })) : f("", true), a(v).visible("statisticsModeName") ? (s(), m(c, { key: "statisticsModeName", prop: "statisticsModeName", "show-overflow-tooltip": "", label: "项目模式", align: "center" })) : f("", true), a(v).visible("statisticsDeadline") ? (s(), m(c, { key: "statisticsDeadline", prop: "statisticsDeadline", "show-overflow-tooltip": "", label: "统计截止日", align: "center" }, { default: g(({ row: e }) => [l(a(S), { type: "date", modelValue: e.statisticsDeadline, "onUpdate:modelValue": (i) => e.statisticsDeadline = i, disabled: !e.isEditing }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 })) : f("", true), a(v).visible("configurePriceScreen") ? (s(), m(c, { key: "configurePriceScreen", "show-overflow-tooltip": "", label: "配置价格修改场景", align: "center", "min-width": "240" }, { default: g(({ row: e }) => [p("div", _e, [l(k, { modelValue: e.configPrice, "onUpdate:modelValue": (i) => e.configPrice = i, options: a(N).ENUM, type: "enum", disabled: !e.isEditing }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]), l(a(S), { type: "daterange", modelValue: e.configurePriceDate, "onUpdate:modelValue": (i) => e.configurePriceDate = i, disabled: !e.isEditing }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])])]), _: 1 })) : f("", true), a(v).visible("signelPeiceScreen") ? (s(), m(c, { key: "signelPeiceScreen", "show-overflow-tooltip": "", label: "单个价格修改场景", align: "center", "min-width": "240" }, { default: g(({ row: e }) => [p("div", ge, [l(k, { modelValue: e.individualPrice, "onUpdate:modelValue": (i) => e.individualPrice = i, options: a(N).ENUM, type: "enum", disabled: !e.isEditing }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]), l(a(S), { type: "daterange", modelValue: e.signelPriceDate, "onUpdate:modelValue": (i) => e.signelPriceDate = i, disabled: !e.isEditing }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])])]), _: 1 })) : f("", true), a(v).visible("options") ? (s(), m(c, { key: "options", prop: "options", "show-overflow-tooltip": "", label: "操作", align: "center", width: "120" }, { default: g(({ row: e }) => [p("div", { class: "btn-container", style: X({ justifyContent: e.isEditing ? "space-between" : "center" }) }, [l(j, { "data-target": "edit", icon: "el-icon-edit", size: "default", type: "primary", onClick: Y((i) => T(e), ["stop"]) }, null, 8, ["onClick"]), e.isEditing ? (s(), m(j, { key: 0, "data-target": "save", onClick: (i) => M(e), icon: "el-icon-stamp", size: "default", type: "success" }, null, 8, ["onClick"])) : f("", true)], 4)]), _: 1 })) : f("", true)]), _: 1 }, 8, ["data", "empty-text"])), [[B, a(D).loading]]), l(a(A))])]);
  };
} }, be = z(fe, [["__scopeId", "data-v-b9692f4f"]]);
export {
  be as default
};
