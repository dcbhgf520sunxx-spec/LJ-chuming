import b from "moment";
import { inject as k } from "vue";
import { ref as u } from "vue";
import { resolveDirective as C } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as P } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withDirectives as Y } from "vue";
import { createBlock as B } from "vue";
import { withCtx as l } from "vue";
import { ElDatePicker as E } from "element-plus";
import { ElCol as q } from "element-plus";
import { ElRow as O } from "element-plus";
import { vLoading as Q } from "element-plus";
import { t as R, B as F } from "../../../../../shared/runtime.js";
import { a as H } from "../../../../../modules/production-statistics-aa5db1ec.js";
import { P as r } from "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const L = { class: "head-container" }, N = { __name: "header", setup(S) {
  const { decimalPrecision: c } = R(), f = b().valueOf(), _ = k("permission"), v = u(false), t = u({}), y = { dateTime: f }, { crud: i, query: m, CRUD: g } = F(y);
  g.HOOK.afterToQuery = () => {
    h();
  };
  async function h() {
    try {
      const o = await H({ dateTime: i.query.dateTime });
      t.value = o || {};
    } catch (o) {
      console.log("根据时间获取全年价格汇总", o);
    }
  }
  function x(o) {
    return o > /* @__PURE__ */ new Date();
  }
  return (o, d) => {
    const V = E, n = q, w = O, D = Q, T = C("permission");
    return p(), P("div", L, [a(V, { modelValue: e(m).dateTime, "onUpdate:modelValue": d[0] || (d[0] = (s) => e(m).dateTime = s), type: "year", size: "default", class: "date-item filter-item", style: { width: "100px !important" }, placeholder: "选择年", format: "YYYY", clearable: false, "value-format": "x", "disabled-date": x, onChange: e(i).toQuery }, null, 8, ["modelValue", "onChange"]), Y((p(), B(w, { gutter: 20, class: "panel-group" }, { default: l(() => [a(n, { span: 8, class: "card-panel-col" }, { default: l(() => [a(e(r), { name: "产量（吨）", "text-color": "#626262", "num-color": "#1890ff", endVal: t.value.mete / 1e3 || 0, precision: 2 }, null, 8, ["endVal"])]), _: 1 }), a(n, { span: 8, class: "card-panel-col" }, { default: l(() => [a(e(r), { name: "工资总额（元）", "text-color": "#626262", "num-color": "#1890ff", endVal: t.value.price || 0, precision: e(c).mes }, null, 8, ["endVal", "precision"])]), _: 1 }), a(n, { span: 8, class: "card-panel-col" }, { default: l(() => {
      var s;
      return [a(e(r), { name: "平均单价（元/吨）", "text-color": "#626262", "num-color": "#1890ff", "end-val": t.value.mete ? ((s = t.value.price) == null ? void 0 : s.toFixed(2)) / (t.value.mete / 1e3).toFixed(2) : 0, precision: e(c).mes }, null, 8, ["end-val", "precision"])];
    }), _: 1 })]), _: 1 })), [[D, v.value], [T, e(_).statistics]])]);
  };
} };
export {
  N as default
};
