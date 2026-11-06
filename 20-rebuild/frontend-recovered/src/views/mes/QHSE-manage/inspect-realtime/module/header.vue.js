import { watch as w } from "vue";
import y from "moment";
import { ref as h } from "vue";
import { computed as U } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as R } from "vue";
import { createElementBlock as N } from "vue";
import { withDirectives as T } from "vue";
import { vShow as A } from "vue";
import { unref as n } from "vue";
import { createElementVNode as V } from "vue";
import { createVNode as r } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as v } from "vue";
import { Fragment as q } from "vue";
import { ElDatePicker as K } from "element-plus";
import { ElCol as F } from "element-plus";
import { ElRow as H } from "element-plus";
import { vLoading as Y } from "element-plus";
import { P as z } from "../../../../../modules/index-5b9e6004.js";
import { g as Z } from "../../../../../modules/inspect-statistics-fca9b551.js";
import { g as $ } from "../../../../../modules/inspect-realtime-8a5aa6e5.js";
import { mI as a, _ as j, B as G, aV as J } from "../../../../../shared/runtime.js";
import { C as M } from "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
function W({ colorCardTitles: f = ["待质检", "待整改", "通过", "让步接收"], emit: D, crud: _, fetchSummaryInfo: C }) {
  const i = [{ title: f[0], color: a.TO_BE_INSPECTED.COLOR, value: a.TO_BE_INSPECTED.V }, { title: f[1], color: a.TO_BE_RECTIFIED.COLOR, value: a.TO_BE_RECTIFIED.V }, { title: f[2], color: a.PASSED.COLOR, value: a.PASSED.V }, { title: f[3], color: a.CONCESSIONLACCEPTED.COLOR, value: a.CONCESSIONLACCEPTED.V }];
  w([() => _.query.monomerId, () => _.query.factoryId], () => {
    typeof C == "function" && C();
  }, { immediate: true });
  function S(o, { complete: s = "completeQuantity", listQuantity: c = "quantity", inProduction: O = "inProductionQuantity" }) {
    return o[s] === 0 && o[O] === 0 ? a.TO_BE_INSPECTED.COLOR : o[s] === o[c] ? a.TO_BE_RECTIFIED.COLOR : o[s] < o[c] && (o[s] > 0 || o[O] > 0) ? a.PASSED.COLOR : a.PASSED.COLOR;
  }
  function e(o, { field: s = "type" }) {
    const c = a.VK[o[s]];
    return c ? a[c].COLOR : a.PASSED.COLOR;
  }
  function I(o, { field: s = "type" }) {
    const c = a.VK[o[s]];
    return c ? a[c].T : a.PASSED.T;
  }
  function m() {
    _.page.hasNextPage && D("load");
  }
  return { colors: i, boxZoomOut: m, getColor: S, getColorByValue: e, getTagByValue: I };
}
const X = { class: "state" }, ee = { __name: "header", emits: "load", setup(f, { emit: D }) {
  const _ = D, C = { date: [y().startOf("day").valueOf(), y().endOf("day").valueOf()], startDate: y().startOf("day").valueOf(), endDate: y().endOf("day").valueOf(), workShopId: void 0, status: a.TO_BE_INSPECTED.V, insepectUserId: void 0 }, { crud: i, CRUD: S, query: e } = G(C), I = h([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), m = h({}), o = h([]), s = h(false);
  async function c() {
    s.value = true;
    try {
      const d = await $(e);
      m.value = d || {};
    } catch (d) {
      console.log(d);
    } finally {
      s.value = false;
    }
  }
  S.HOOK.handleRefresh = async (d, { data: l }) => {
    c();
  };
  const O = U(() => {
    var l, E, g;
    let d = [];
    if ((l = o.value) != null && l.length) if (e.workShopId && o.value.length) (E = o.value) == null || E.forEach((u) => {
      u.workshopId === e.workShopId && (d = u.inspectUsers || []);
    });
    else {
      const u = (g = o.value) == null ? void 0 : g.map((p) => p.inspectUsers);
      d = (u == null ? void 0 : u.flat()) || [];
    }
    return d;
  });
  async function P(d) {
    try {
      o.value = await Z();
    } catch (l) {
      console.log(l);
    }
  }
  P();
  const { colors: B } = W({ emit: _, crud: i });
  function L() {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), i.toQuery();
  }
  return (d, l) => {
    const E = K, g = b("common-select"), u = z, p = F, x = H, k = Y;
    return R(), N(q, null, [T(V("div", null, [r(E, { modelValue: n(e).date, "onUpdate:modelValue": l[0] || (l[0] = (t) => n(e).date = t), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", "default-time": I.value, "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, class: "filter-item", onChange: L }, null, 8, ["modelValue", "default-time"]), r(n(J), { modelValue: n(e).workShopId, "onUpdate:modelValue": l[1] || (l[1] = (t) => n(e).workShopId = t), placeholder: "请选择车间", clearable: "", style: { width: "200px" }, class: "filter-item", onChange: n(i).toQuery }, null, 8, ["modelValue", "onChange"]), r(g, { modelValue: n(e).insepectUserId, "onUpdate:modelValue": l[2] || (l[2] = (t) => n(e).insepectUserId = t), dataStructure: { key: "id", label: "name", value: "id" }, options: O.value, class: "filter-item", clearable: "", placeholder: "全部质检员", style: { width: "180px" }, type: "other", onChange: n(i).toQuery }, null, 8, ["modelValue", "options", "onChange"])], 512), [[A, n(i).searchToggle]]), V("div", null, [T((R(), Q(x, { gutter: 20, class: "panel-group custom-row" }, { default: v(() => [r(p, { class: "card-panel-col custom-col" }, { default: v(() => {
      var t;
      return [r(u, { name: "待质检", "text-color": "#626262", "num-color": "#00bcff", "end-val": ((t = m.value) == null ? void 0 : t.toBeInspectedCount) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), r(p, { class: "card-panel-col custom-col" }, { default: v(() => {
      var t;
      return [r(u, { name: "待整改", "text-color": "#626262", "num-color": "#f00a0a", "end-val": ((t = m.value) == null ? void 0 : t.toBeRectifiedCount) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), r(p, { class: "card-panel-col custom-col" }, { default: v(() => {
      var t;
      return [r(u, { name: "通过", "text-color": "#626262", "num-color": "#199a30", "end-val": ((t = m.value) == null ? void 0 : t.passedCount) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), r(p, { class: "card-panel-col custom-col" }, { default: v(() => {
      var t;
      return [r(u, { name: "让步接收", "text-color": "#626262", "num-color": "#faac09", "end-val": ((t = m.value) == null ? void 0 : t.concessionReceivingCount) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 })]), _: 1 })), [[k, s.value]])]), V("div", X, [r(n(M), { class: "filter-item", value: n(e).status, "onUpdate:value": l[3] || (l[3] = (t) => n(e).status = t), colors: n(B), "color-border": "", "select-able": "", onChange: n(i).toQuery }, null, 8, ["value", "colors", "onChange"])])], 64);
  };
} }, ue = j(ee, [["__scopeId", "data-v-a0a73424"]]);
export {
  ue as default
};
