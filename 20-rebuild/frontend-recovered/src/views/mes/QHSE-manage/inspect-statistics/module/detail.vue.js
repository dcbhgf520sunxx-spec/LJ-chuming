import { ref as w } from "vue";
import { useRouter as Q } from "vue-router";
import { resolveComponent as H } from "vue";
import { openBlock as e } from "vue";
import { createBlock as N } from "vue";
import { withCtx as l } from "vue";
import { createVNode as u } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as r } from "vue";
import { createElementBlock as n } from "vue";
import { Fragment as v } from "vue";
import { renderList as V } from "vue";
import { createTextVNode as C } from "vue";
import { withDirectives as K } from "vue";
import { createCommentVNode as j } from "vue";
import { unref as k } from "vue";
import { isRef as U } from "vue";
import { ElDescriptionsItem as $ } from "element-plus";
import { ElDescriptions as A } from "element-plus";
import { ElStep as G } from "element-plus";
import { ElSteps as J } from "element-plus";
import { vLoading as W } from "element-plus";
import { b as X } from "../../../../../modules/inspect-statistics-fca9b551.js";
import { _ as Y, u as Z, p as E } from "../../../../../shared/runtime.js";
const m = { key: 1 }, aa = ["onClick"], ea = { key: 1 }, sa = { class: "steps" }, ta = { key: 0 }, la = { key: 1, style: { "margin-left": "20px" } }, na = { key: 2, style: { "margin-left": "40px" } }, oa = { key: 3 }, ra = { __name: "detail", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(s, { emit: M }) {
  const R = w(), B = M, b = s, { visible: D, handleClose: L } = Z({ emit: B, props: b, field: "visible", showHook: O }), S = Q(), x = w([]), h = w(false);
  async function q() {
    var t, d, y;
    let p = [];
    h.value = true;
    try {
      const _ = { number: (t = b.detailData) == null ? void 0 : t.number, productId: (d = b.detailData) == null ? void 0 : d.productId, taskProcessId: (y = b.detailData) == null ? void 0 : y.taskProcessId };
      p = await X(_);
    } catch (_) {
      console.log(_);
    } finally {
      x.value = p, h.value = false;
    }
  }
  function O() {
    q();
  }
  function P(p) {
    console.log(p, "dsadasdasdasd"), S.push({ name: "MesQualityProblemStatistics", params: { qhseId: p } });
  }
  return (p, t) => {
    const d = $, y = A, _ = G, T = J, z = H("common-drawer"), F = W;
    return e(), N(z, { ref_key: "drawerRef", ref: R, title: "构件溯源", modelValue: k(D), "onUpdate:modelValue": t[0] || (t[0] = (a) => U(D) ? D.value = a : null), direction: "rtl", "before-close": k(L), size: "40%" }, { titleRight: l(() => t[1] || (t[1] = [])), content: l(() => [u(y, { data: s.detailData, column: 2, size: "large", border: "" }, { default: l(() => [u(d, { align: "center", label: "项目" }, { default: l(() => {
      var a, o;
      return [i("span", null, r(((o = (a = s.detailData) == null ? void 0 : a.project) == null ? void 0 : o.shortName) || "-"), 1)];
    }), _: 1 }), u(d, { align: "center", label: "单体" }, { default: l(() => {
      var a;
      return [i("span", null, r(((a = s.detailData) == null ? void 0 : a.monomerName) || "-"), 1)];
    }), _: 1 }), u(d, { align: "center", label: "区域" }, { default: l(() => {
      var a;
      return [i("span", null, r(((a = s.detailData) == null ? void 0 : a.areaName) || "-"), 1)];
    }), _: 1 }), u(d, { align: "center", label: "编号" }, { default: l(() => {
      var a;
      return [i("span", null, r(((a = s.detailData) == null ? void 0 : a.serialNumber) || "-"), 1)];
    }), _: 1 }), u(d, { align: "center", label: "关联部件", span: 2 }, { default: l(() => {
      var a, o;
      return [(a = s.detailData) != null && a.assMap ? (e(true), n(v, { key: 0 }, V(Object.values((o = s.detailData) == null ? void 0 : o.assMap), (c) => (e(), n("span", { key: c }, " 【" + r(c) + "】 ", 1))), 128)) : (e(), n("span", m, "-"))];
    }), _: 1 }), u(d, { align: "center", label: "质量缺陷", span: 2 }, { default: l(() => {
      var a, o;
      return [(a = s.detailData) != null && a.qhseMap ? (e(true), n(v, { key: 0 }, V(Object.values((o = s.detailData) == null ? void 0 : o.qhseMap), (c, g) => (e(), n(v, { key: c }, [t[2] || (t[2] = C(" 【")), i("span", { class: "serialNumber", onClick: (I) => {
        var f;
        return P(Object.keys((f = s.detailData) == null ? void 0 : f.qhseMap)[g]);
      } }, r(c), 9, aa), t[3] || (t[3] = C("】 "))], 64))), 128)) : (e(), n("span", ea, "-"))];
    }), _: 1 })]), _: 1 }, 8, ["data"]), i("div", sa, [K((e(), N(T, { direction: "vertical" }, { default: l(() => [(e(true), n(v, null, V(x.value, (a, o) => {
      var c, g;
      return e(), N(_, { key: o, title: a != null && a.boolInspect ? "质检： " + ((c = a == null ? void 0 : a.user) == null ? void 0 : c.name) : (g = a == null ? void 0 : a.productionLine) == null ? void 0 : g.name }, { description: l(() => {
        var I, f;
        return [a != null && a.boolInspect ? j("", true) : (e(), n("span", ta, " 工序：" + r(((I = a == null ? void 0 : a.process) == null ? void 0 : I.name) || "-"), 1)), a != null && a.boolInspect ? j("", true) : (e(), n("span", la, "班组：" + r(((f = a == null ? void 0 : a.team) == null ? void 0 : f.name) || "-"), 1)), a != null && a.boolInspect ? (e(), n("span", oa, "质检日期：" + r(a != null && a.date ? k(E)(a == null ? void 0 : a.date, "{y}-{m}-{d} {h}:{i}") : "-"), 1)) : (e(), n("span", na, " 上报日期：" + r(a != null && a.date ? k(E)(a == null ? void 0 : a.date, "{y}-{m}-{d} {h}:{i}") : "-"), 1))];
      }), _: 2 }, 1032, ["title"]);
    }), 128))]), _: 1 })), [[F, h.value]])])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, pa = Y(ra, [["__scopeId", "data-v-aec90d17"]]);
export {
  pa as default
};
