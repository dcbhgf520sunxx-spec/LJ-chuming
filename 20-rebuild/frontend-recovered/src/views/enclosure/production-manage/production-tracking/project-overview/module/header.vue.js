import { computed as H } from "vue";
import { ref as n } from "vue";
import { watch as Z } from "vue";
import { nextTick as F } from "vue";
import { resolveComponent as K } from "vue";
import { resolveDirective as h } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as j } from "vue";
import { withDirectives as d } from "vue";
import { vShow as P } from "vue";
import { unref as t } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as c } from "vue";
import { withCtx as m } from "vue";
import { createBlock as b } from "vue";
import { createTextVNode as v } from "vue";
import { toDisplayString as G } from "vue";
import { ElTag as J } from "element-plus";
import { vLoading as W } from "element-plus";
import { e as X, a as Y } from "../../../../../../modules/project-overview-0b01c4c7.js";
import { _ as $, B as ee, kA as ae, D as w, E as te, bs as oe } from "../../../../../../shared/runtime.js";
import { S as re } from "../../../../../../modules/index-21d3d7d7.js";
import { C as le } from "../../../../../../modules/index-d6a37d29.js";
import { u as se } from "../../../../../../modules/use-dashboard-header-292e247c.js";
import ne from "./monomer-select-area-select.vue.js";
import "../../../../../../modules/convert-product-type-fcb585d7.js";
const de = { class: "area-wrap" }, ie = { __name: "header", props: { project: { type: Object, default: () => {
} } }, emits: "load", setup(S, { expose: E, emit: q }) {
  const O = q, D = { dictionaryId: void 0, areaIds: [], status: { value: void 0, resetAble: false } }, { crud: o, query: s, CRUD: k } = ee(D);
  H(() => Object.keys(ae.V).map((r) => +r));
  const C = n([]), N = n({ key: "id", value: "id", label: "label" }), L = S;
  Z(() => s.dictionaryId, (r) => {
    F(() => {
    });
  }, { immediate: true });
  const R = n(false);
  n([]), n(false), n(false);
  const p = n(false), l = n({}), _ = n(1), { colors: U, boxZoomOut: V, getColor: Q } = se({ colorCardTitles: ["未生产", "生产中", "已完成"], emit: O, crud: o });
  async function I() {
    var r;
    try {
      p.value = true, l.value = { totalLength: 0, completedLength: 0 }, (r = s.areaIds) != null && r.length && (l.value = await X({ projectId: L.project.id, areaIds: s.areaIds, dictionaryId: s.dictionaryId })), l.value.completeRate = Number(l.value.completedLength) && Number(l.value.totalLength) ? oe(l.value.completedLength / l.value.totalLength * 100, 2) : 0;
    } catch (e) {
      console.log("获取获取围护汇总失败", e);
    } finally {
      p.value = false;
    }
  }
  async function T(r) {
    try {
      s.dictionaryId = void 0;
      const e = await Y(r);
      C.value = Object.entries(e).map(([i, u]) => ({ id: Number(i), label: u })), o.toQuery(), I();
    } catch {
      console.log("获取所有项目下全部的围护种类失败");
    } finally {
    }
  }
  async function z(r) {
    r.areaId ? o.query.areaIds = [r.areaId] : o.query.areaIds = r.areaList.map((e) => e.id), await T({ areaIds: o.query.areaIds }), o.toQuery(), I();
  }
  async function B() {
    await o.toQuery(), await I();
  }
  return k.HOOK.handleRefresh = async (r, { data: e }) => {
    e.content.forEach((i) => {
      i.boxColor = Q(i, { quantity: "producedQuantity", compare: "quantity" });
    });
  }, E({ boxScale: _ }), (r, e) => {
    const i = K("common-radio-button"), u = J, g = W, M = h("empty-text"), A = h("parse-project"), x = h("thousand");
    return y(), j("div", null, [d(f("div", null, [d((y(), j("div", de, [c(ne, { "area-id": t(o).query.areaId, "onUpdate:areaId": e[0] || (e[0] = (a) => t(o).query.areaId = a), "monomer-id": t(o).query.monomerId, "onUpdate:monomerId": e[1] || (e[1] = (a) => t(o).query.monomerId = a), "project-id": t(o).query.projectId, onChange: z }, null, 8, ["area-id", "monomer-id", "project-id"])])), [[g, R.value]]), f("div", null, [c(i, { modelValue: t(s).dictionaryId, "onUpdate:modelValue": e[2] || (e[2] = (a) => t(s).dictionaryId = a), "data-structure": N.value, options: C.value, class: "filter-item", showOptionAll: "", size: "default", type: "other", onChange: B }, null, 8, ["modelValue", "data-structure", "options"])])], 512), [[P, t(o).searchToggle]]), c(t(te), { "show-grid": false, "show-refresh": false }, { optRight: m(() => [c(t(le), { value: t(s).status, "onUpdate:value": e[3] || (e[3] = (a) => t(s).status = a), colors: t(U), class: "filter-item", "color-border": "", "select-able": "", onChange: t(o).toQuery }, null, 8, ["value", "colors", "onChange"])]), viewLeft: m(() => [c(t(re), { value: _.value, "onUpdate:value": e[4] || (e[4] = (a) => _.value = a), intervals: 400, onZoomOut: t(V) }, null, 8, ["value", "onZoomOut"]), c(u, { effect: "plain", size: "large", style: { "margin-right": "6px" } }, { default: m(() => [d(f("span", null, null, 512), [[M], [A, { project: L.project }]])]), _: 1 }), d((y(), b(u, { effect: "plain", size: "large", style: { "margin-right": "6px" }, type: "success" }, { default: m(() => {
      var a;
      return [e[5] || (e[5] = v(" 总量：")), d(f("span", null, null, 512), [[x, { val: ((a = l.value) == null ? void 0 : a.totalLength) || 0, dp: t(w).MES_ENCLOSURE_L__M }]]), e[6] || (e[6] = v(" m "))];
    }), _: 1, __: [5, 6] })), [[g, p.value]]), d((y(), b(u, { effect: "plain", size: "large", style: { "margin-right": "6px" }, type: "success" }, { default: m(() => {
      var a;
      return [e[7] || (e[7] = v(" 已生产：")), d(f("span", null, null, 512), [[x, { val: ((a = l.value) == null ? void 0 : a.completedLength) || 0, dp: t(w).MES_ENCLOSURE_L__M }]]), e[8] || (e[8] = v(" m "))];
    }), _: 1, __: [7, 8] })), [[g, p.value]]), d((y(), b(u, { effect: "plain", size: "large", type: "success" }, { default: m(() => {
      var a;
      return [v(" 完成率：" + G(((a = l.value) == null ? void 0 : a.completeRate) || 0) + " % ", 1)];
    }), _: 1 })), [[g, p.value]])]), _: 1 })]);
  };
} }, _e = $(ie, [["__scopeId", "data-v-5dec9aac"]]);
export {
  _e as default
};
