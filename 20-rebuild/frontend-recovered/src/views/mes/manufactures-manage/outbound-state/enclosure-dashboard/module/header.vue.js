import { ref as g } from "vue";
import { resolveDirective as M } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as m } from "vue";
import { withDirectives as v } from "vue";
import { vShow as B } from "vue";
import { unref as e } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as n } from "vue";
import { withKeys as Q } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as p } from "vue";
import { createBlock as h } from "vue";
import { ElInput as N } from "element-plus";
import { Loading as A } from "@element-plus/icons-vue";
import { ElIcon as K } from "element-plus";
import { ElTag as j } from "element-plus";
import { c as F } from "../../../../../../modules/common-85b8c78d.js";
import { o3 as H, B as P, a3 as Z, m as z, C as W, bs as E, D as S, E as G } from "../../../../../../shared/runtime.js";
import { u as J } from "../../../../../../modules/use-dashboard-header-292e247c.js";
import { C as X } from "../../../../../../modules/index-d6a37d29.js";
import { S as Y } from "../../../../../../modules/index-21d3d7d7.js";
import { _ as ee } from "../../../../../../modules/index-b238c21c.js";
import { _ as te } from "../../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import { _ as oe } from "../../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../../modules/index-8356a01a.js";
const ae = { class: "head-container" }, ne = { key: 0 }, le = { key: 0 }, se = { key: 0 }, ge = { __name: "header", emits: "load", setup(re, { expose: V, emit: k }) {
  const q = { name: "", serialNumber: "", plate: "", color: "", type: H.OUTBOUND.V, status: { value: void 0, resetAble: false }, monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, factoryId: { value: void 0, resetAble: false } }, { crud: l, query: a, CRUD: x } = P(q), C = Z.ENCLOSURE.V, { globalProjectId: w } = z(["globalProjectId"]), O = k, y = g(1), d = g(false), c = g({ mete: void 0, outboundMete: void 0, outboundRate: void 0 }), { colors: T, boxZoomOut: U, getColor: R } = J({ colorCardTitles: ["未出库", "部分出库", "全部出库"], emit: O, crud: l, fetchSummaryInfo: $ });
  async function $() {
    if (a.monomerId) {
      d.value = true;
      try {
        const s = { monomerId: a.monomerId, factoryId: a.factoryId }, { mete: t = 0, outboundMete: o = 0 } = await F(s);
        c.value = { mete: t, outboundMete: o, outboundRate: t ? (o / t * 100).toFixed(1) + "%" : 0 };
      } catch (s) {
        console.log("获取汇总数据", s);
      } finally {
        d.value = false;
      }
    }
  }
  x.HOOK.handleRefresh = (s, t) => {
    t.data.content = t.data.content.map((o) => (o.compareQuantity = s.query.factoryId ? o.taskQuantity : o.quantity, o.quantityInfo = `-------------------------

清单数量：${o.quantity}

`, s.query.factoryId && (o.quantityInfo += `任务数量：${o.taskQuantity}

`), o.quantityInfo += `入库数量：${o.inboundQuantity}

        出库数量：${o.outboundQuantity}

        库存数量：${o.inboundQuantity - o.outboundQuantity}
`, o.boxColor = R(o, { quantity: "outboundQuantity", compare: "compareQuantity" }), o));
  };
  function D({ monomerId: s, areaId: t }) {
    a.monomerId = s, a.areaId = t, l.toQuery();
  }
  return V({ boxScale: y }), (s, t) => {
    const o = N, _ = A, b = K, I = j, L = M("permission");
    return u(), m("div", ae, [v(f("div", null, [n(e(te), { "project-id": e(w), productType: e(C), needConvert: "", onChange: D }, null, 8, ["project-id", "productType"]), n(e(oe), { modelValue: e(a).factoryId, "onUpdate:modelValue": t[0] || (t[0] = (r) => e(a).factoryId = r), clearable: "", class: "filter-item", style: { width: "200px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), n(e(ee), { productType: e(C), toQuery: e(l).toQuery, query: e(a) }, null, 8, ["productType", "toQuery", "query"]), n(o, { modelValue: e(a).plate, "onUpdate:modelValue": t[1] || (t[1] = (r) => e(a).plate = r), size: "default", placeholder: "输入板型搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: Q(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(o, { modelValue: e(a).color, "onUpdate:modelValue": t[2] || (t[2] = (r) => e(a).color = r), size: "default", placeholder: "输入颜色搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: Q(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(W))], 512), [[B, e(l).searchToggle]]), n(e(G), { "show-grid": false, "show-refresh": false }, { optRight: i(() => [n(e(X), { class: "filter-item", value: e(a).status, "onUpdate:value": t[3] || (t[3] = (r) => e(a).status = r), colors: e(T), "color-border": "", "select-able": "", onChange: e(l).toQuery }, null, 8, ["value", "colors", "onChange"])]), viewLeft: i(() => [v((u(), m("span", null, [n(I, { effect: "plain", class: "filter-item" }, { default: i(() => [f("span", null, p(e(a).factoryId ? "任务量" : "清单量") + "：", 1), d.value ? (u(), h(b, { key: 1 }, { default: i(() => [n(_)]), _: 1 })) : (u(), m("span", ne, p(e(E)(c.value.mete, e(S).MES_ENCLOSURE_L__M)) + " m", 1))]), _: 1 }), n(I, { effect: "plain", class: "filter-item" }, { default: i(() => [t[5] || (t[5] = f("span", null, "出库量：", -1)), d.value ? (u(), h(b, { key: 1 }, { default: i(() => [n(_)]), _: 1 })) : (u(), m("span", le, p(e(E)(c.value.outboundMete, e(S).MES_ENCLOSURE_L__M)) + " m", 1))]), _: 1, __: [5] }), n(I, { effect: "plain", class: "filter-item", type: "success" }, { default: i(() => [t[6] || (t[6] = f("span", null, "完成率：", -1)), d.value ? (u(), h(b, { key: 1 }, { default: i(() => [n(_)]), _: 1 })) : (u(), m("span", se, p(c.value.outboundRate), 1))]), _: 1, __: [6] })])), [[L, e(l).permission.get]]), n(e(Y), { class: "filter-item", value: y.value, "onUpdate:value": t[4] || (t[4] = (r) => y.value = r), intervals: 400, onZoomOut: e(U) }, null, 8, ["value", "onZoomOut"])]), _: 1 })]);
  };
} };
export {
  ge as default
};
