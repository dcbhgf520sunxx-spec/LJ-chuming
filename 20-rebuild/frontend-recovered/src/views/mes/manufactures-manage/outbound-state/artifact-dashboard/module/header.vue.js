import { ref as g } from "vue";
import { resolveDirective as U } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as m } from "vue";
import { withDirectives as T } from "vue";
import { vShow as V } from "vue";
import { unref as e } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as a } from "vue";
import { withCtx as u } from "vue";
import { toDisplayString as p } from "vue";
import { createBlock as I } from "vue";
import { Loading as B } from "@element-plus/icons-vue";
import { ElIcon as M } from "element-plus";
import { ElTag as j } from "element-plus";
import { a as F } from "../../../../../../modules/common-85b8c78d.js";
import { o3 as N, B as W, a3 as G, m as H, ng as K, C as L, bs as h, D as v, E as P } from "../../../../../../shared/runtime.js";
import { u as Z } from "../../../../../../modules/use-dashboard-header-292e247c.js";
import { C as z } from "../../../../../../modules/index-d6a37d29.js";
import { S as J } from "../../../../../../modules/index-21d3d7d7.js";
import { _ as X } from "../../../../../../modules/index-b238c21c.js";
import { _ as Y } from "../../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import { _ as ee } from "../../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../../modules/index-8356a01a.js";
const te = { class: "head-container" }, oe = { key: 0 }, ae = { key: 0 }, ne = { key: 0 }, be = { __name: "header", emits: "load", setup(se, { expose: Q, emit: k }) {
  const q = { name: "", serialNumber: "", specification: "", material: "", type: N.OUTBOUND.V, status: { value: void 0, resetAble: false }, monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, factoryId: { value: void 0, resetAble: false } }, { crud: l, query: n, CRUD: x } = W(q), C = G.ARTIFACT.V, { globalProjectId: O } = H(["globalProjectId"]), R = k, y = g(1), i = g(false), c = g({ mete: void 0, outboundMete: void 0, outboundRate: void 0 }), { colors: A, boxZoomOut: E, getColor: S } = Z({ colorCardTitles: ["未出库", "部分出库", "全部出库"], emit: R, crud: l, fetchSummaryInfo: $ });
  async function $() {
    if (n.monomerId) {
      i.value = true;
      try {
        const s = { monomerId: n.monomerId, factoryId: n.factoryId }, { mete: o = 0, outboundMete: t = 0 } = await F(s);
        c.value = { mete: o, outboundMete: t, outboundRate: o ? (t / o * 100).toFixed(1) + "%" : 0 };
      } catch (s) {
        console.log("获取汇总数据", s);
      } finally {
        i.value = false;
      }
    }
  }
  x.HOOK.handleRefresh = (s, o) => {
    o.data.content = o.data.content.map((t) => (t.compareQuantity = s.query.factoryId ? t.taskQuantity : t.quantity, t.quantityInfo = `-------------------------

清单数量：${t.quantity}

`, s.query.factoryId && (t.quantityInfo += `任务数量：${t.taskQuantity}

`), t.quantityInfo += `入库数量：${t.inboundQuantity}

        出库数量：${t.outboundQuantity}

        库存数量：${t.inboundQuantity - t.outboundQuantity}
`, t.boxColor = S(t, { quantity: "outboundQuantity", compare: "compareQuantity" }), t));
  };
  function w({ monomerId: s, areaId: o }) {
    n.monomerId = s, n.areaId = o, l.toQuery();
  }
  return Q({ boxScale: y }), (s, o) => {
    const t = B, _ = M, b = j, D = U("permission");
    return r(), m("div", te, [T(f("div", null, [a(e(Y), { "project-id": e(O), areaType: e(K).STRUCTURE.V, productType: e(C), needConvert: "", onChange: w }, null, 8, ["project-id", "areaType", "productType"]), a(e(ee), { modelValue: e(n).factoryId, "onUpdate:modelValue": o[0] || (o[0] = (d) => e(n).factoryId = d), clearable: "", class: "filter-item", style: { width: "200px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), a(e(X), { productType: e(C), toQuery: e(l).toQuery, query: e(n) }, null, 8, ["productType", "toQuery", "query"]), a(e(L))], 512), [[V, e(l).searchToggle]]), a(e(P), { "show-grid": false, "show-refresh": false }, { optRight: u(() => [a(e(z), { class: "filter-item", value: e(n).status, "onUpdate:value": o[1] || (o[1] = (d) => e(n).status = d), colors: e(A), "color-border": "", "select-able": "", onChange: e(l).toQuery }, null, 8, ["value", "colors", "onChange"])]), viewLeft: u(() => [T((r(), m("span", null, [a(b, { effect: "plain", class: "filter-item" }, { default: u(() => [f("span", null, p(e(n).factoryId ? "任务量" : "清单量") + "：", 1), i.value ? (r(), I(_, { key: 1 }, { default: u(() => [a(t)]), _: 1 })) : (r(), m("span", oe, p(e(h)(c.value.mete, e(v).COM_WT__KG)) + " kg", 1))]), _: 1 }), a(b, { effect: "plain", class: "filter-item" }, { default: u(() => [o[3] || (o[3] = f("span", null, "出库量：", -1)), i.value ? (r(), I(_, { key: 1 }, { default: u(() => [a(t)]), _: 1 })) : (r(), m("span", ae, p(e(h)(c.value.outboundMete, e(v).COM_WT__KG)) + " kg", 1))]), _: 1, __: [3] }), a(b, { effect: "plain", class: "filter-item", type: "success" }, { default: u(() => [o[4] || (o[4] = f("span", null, "完成率：", -1)), i.value ? (r(), I(_, { key: 1 }, { default: u(() => [a(t)]), _: 1 })) : (r(), m("span", ne, p(c.value.outboundRate), 1))]), _: 1, __: [4] })])), [[D, e(l).permission.get]]), a(e(J), { class: "filter-item", value: y.value, "onUpdate:value": o[2] || (o[2] = (d) => y.value = d), intervals: 400, onZoomOut: e(E) }, null, 8, ["value", "onZoomOut"])]), _: 1 })]);
  };
} };
export {
  be as default
};
