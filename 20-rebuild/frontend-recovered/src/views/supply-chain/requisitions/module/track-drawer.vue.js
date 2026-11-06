import { ref as d } from "vue";
import { inject as q } from "vue";
import { resolveComponent as j } from "vue";
import { resolveDirective as A } from "vue";
import { openBlock as c } from "vue";
import { createBlock as f } from "vue";
import { withCtx as s } from "vue";
import { createElementBlock as F } from "vue";
import { toDisplayString as O } from "vue";
import { unref as a } from "vue";
import { createCommentVNode as B } from "vue";
import { withDirectives as w } from "vue";
import { createTextVNode as G } from "vue";
import { createVNode as l } from "vue";
import { createElementVNode as r } from "vue";
import { isRef as U } from "vue";
import { ElCol as J } from "element-plus";
import { ElRow as K } from "element-plus";
import { vLoading as Q } from "element-plus";
import { _ as W, u as X, o as Y, wz as Z, cO as V, jl as C, z as ee, L as ae, wA as te, j_ as oe, jG as R, jH as E } from "../../../../shared/runtime.js";
import { P as x } from "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const se = { key: 0 }, le = { style: { display: "flex" } }, ne = { style: { flex: "1" } }, ie = { style: { flex: "1" } }, re = { __name: "track-drawer", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => ({}) } }, emits: ["update:visible"], setup(n, { emit: D }) {
  const H = d(), N = D, u = n, { visible: m, handleClose: I } = X({ emit: N, props: u, field: "visible", showHook: S }), M = q("permission"), { maxHeight: g } = Y({ extraBox: [".el-drawer__header", "panel-group"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, m), y = d({}), _ = d([]), v = d([]), p = d(false);
  function S() {
    z();
  }
  async function z() {
    if (_.value = [], v.value = [], y.value = {}, !!u.info.id) try {
      p.value = true;
      const t = await Z(u.info.id);
      await V(t.detailList), await C(t.detailList), await V(t.inboundList), await C(t.inboundList), _.value = t.detailList, v.value = t.inboundList, y.value = t;
    } catch (t) {
      console.log(t);
    } finally {
      p.value = false;
    }
  }
  return (t, i) => {
    var L;
    const b = J, P = K, h = j("common-table"), T = j("common-drawer"), $ = A("permission"), k = Q;
    return c(), f(T, { ref_key: "drawerRef", ref: H, title: `申购单号：${(L = n.info) == null ? void 0 : L.serialNumber}`, modelValue: a(m), "onUpdate:modelValue": i[0] || (i[0] = (o) => U(m) ? m.value = o : null), direction: "rtl", "before-close": a(I), size: "100%" }, { titleAfter: s(() => {
      var o, e;
      return [(o = n.info) != null && o.project ? (c(), F("span", se, " 【" + O(a(ee)((e = n.info) == null ? void 0 : e.project)) + "】 ", 1)) : B("", true)];
    }), titleRight: s(() => {
      var o, e;
      return [w((c(), f(ae, { size: "default", params: { id: (o = u.info) == null ? void 0 : o.id }, fn: a(te) }, { default: s(() => i[1] || (i[1] = [G(" 下载 ")])), _: 1, __: [1] }, 8, ["params", "fn"])), [[$, (e = a(M)) == null ? void 0 : e.trackPrint]])];
    }), content: s(() => {
      var o;
      return [((o = n.info) == null ? void 0 : o.materialType) === a(oe).STEEL.V ? (c(), f(P, { key: 0, gutter: 20, class: "panel-group" }, { default: s(() => [l(b, { span: 8, class: "card-panel-col" }, { default: s(() => {
        var e;
        return [l(a(x), { name: "申购计划(kg)", "text-color": "#626262", "num-color": "#1890ff", "end-val": ((e = n.info) == null ? void 0 : e.totalMete) || 0, precision: 2 }, null, 8, ["end-val"])];
      }), _: 1 }), l(b, { span: 8, class: "card-panel-col" }, { default: s(() => {
        var e;
        return [l(a(x), { name: "实际入库(kg)", "text-color": "#626262", "num-color": "#1890ff", "end-val": ((e = n.info) == null ? void 0 : e.inboundMete) || 0, precision: 2 }, null, 8, ["end-val"])];
      }), _: 1 }), l(b, { span: 8, class: "card-panel-col" }, { default: s(() => {
        var e;
        return [l(a(x), { name: "入库率(%)", "text-color": "#626262", "num-color": "#1890ff", "end-val": ((e = n.info) == null ? void 0 : e.inboundRate) || 0, precision: 2 }, null, 8, ["end-val"])];
      }), _: 1 })]), _: 1 })) : B("", true), r("div", le, [r("div", ne, [i[2] || (i[2] = r("div", { class: "table-title", style: { "background-color": "#ecf5ff" } }, [r("span", null, "申购数据")], -1)), w((c(), f(h, { data: _.value, "max-height": a(g), style: { width: "100%" } }, { default: s(() => [l(R), l(E)]), _: 1 }, 8, ["data", "max-height"])), [[k, p.value]])]), r("div", ie, [i[3] || (i[3] = r("div", { class: "table-title", style: { "background-color": "#f5ffef" } }, [r("span", null, "入库数据")], -1)), w((c(), f(h, { data: v.value, "max-height": a(g), style: { width: "100%" } }, { default: s(() => [l(R), l(E)]), _: 1 }, 8, ["data", "max-height"])), [[k, p.value]])])])];
    }), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, me = W(re, [["__scopeId", "data-v-edfe343b"]]);
export {
  me as default
};
