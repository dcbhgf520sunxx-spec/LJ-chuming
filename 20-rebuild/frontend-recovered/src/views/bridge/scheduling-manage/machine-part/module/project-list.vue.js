import { ref as r } from "vue";
import x from "moment";
import { nextTick as V } from "vue";
import { resolveComponent as Y } from "vue";
import { openBlock as j } from "vue";
import { createElementBlock as M } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as d } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as D } from "vue";
import { withCtx as w } from "vue";
import { toDisplayString as k } from "vue";
import { Fragment as E } from "vue";
import { ElTableColumn as F } from "element-plus";
import { vLoading as H } from "element-plus";
import { d as R, e as q } from "../../../../../modules/machine-part-b1b959c2.js";
import { _ as G, G as S, i as U, b as L } from "../../../../../shared/runtime.js";
import { C as I } from "../../../../../modules/bridge-86f96a4f.js";
import W from "../../common/project-header-time.vue.js";
const z = { class: "head-container" }, A = { __name: "project-list", props: { maxHeight: { type: [Number, String], default: void 0 } }, emits: ["project-click"], setup(C, { expose: y, emit: T }) {
  const B = T, s = r([]), h = r(false), v = r(), n = r([]), u = r([]), f = r(false), N = r([["project", "parse-project"]]);
  _();
  async function _(e) {
    var l, i, a, c;
    if (S(I.get)) try {
      s.value = [], u.value = [], n.value = [], h.value = true;
      const { content: o } = await R();
      if (s.value = o.map((t) => {
        const p = x(t, "YYYY-MM").valueOf(), m = t.split("-");
        return { timeStamp: p, year: m[0], month: m[1] };
      }), e && U(e.monthList) && ((l = s.value) != null && l.length)) for (let t = 0; t < e.monthList.length; t++) {
        const p = e.monthList[t];
        ((i = s.value) == null ? void 0 : i.findIndex((m) => m.timeStamp === p)) !== -1 && n.value.push(p);
      }
      if (L(n.value) && ((a = s.value) != null && a.length)) {
        const t = x().startOf("month").valueOf();
        ((c = s.value) == null ? void 0 : c.findIndex((m) => m.timeStamp === t)) !== -1 ? n.value.push(t) : n.value = [s.value[0].timeStamp];
      }
      await g(e);
    } catch (o) {
      console.log("获取排程信息时间错误", o);
    } finally {
      h.value = false;
    }
  }
  async function g(e) {
    if (u.value = [], !(!S(I.get) || L(n.value))) try {
      f.value = true;
      const { content: l } = await q({ monthList: n.value }), i = [];
      u.value = l.map((a, c) => {
        var o;
        return a.projectId = (o = a.project) == null ? void 0 : o.id, e && (e == null ? void 0 : e.projectIds.indexOf(a.projectId)) !== -1 && i.push(c), a;
      }), i.forEach((a) => {
        V(() => {
          var c;
          (c = v.value) == null || c.toggleRowSelection(u.value[a], true);
        });
      });
    } catch (l) {
      console.log("获取排程信息，项目树错误", l);
    } finally {
      f.value = false;
    }
  }
  function P(e) {
    B("project-click", e, n.value);
  }
  return y({ refresh: _ }), (e, l) => {
    const i = F, a = Y("common-table"), c = H;
    return j(), M(E, null, [b("div", z, [d(W, { modelValue: n.value, "onUpdate:modelValue": l[0] || (l[0] = (o) => n.value = o), multiple: "", data: s.value, onChange: g, "empty-text": "暂无零件排产信息" }, null, 8, ["modelValue", "data"])]), O((j(), D(a, { ref_key: "projectTableRef", ref: v, "data-format": N.value, data: u.value, stripe: false, "max-height": C.maxHeight, style: { width: "100%" }, onSelectionChange: P }, { default: w(() => [d(i, { type: "selection", width: "45", align: "center" }), d(i, { prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "100" }), d(i, { "show-overflow-tooltip": true, label: "零件量（件|kg）", "min-width": "60", align: "center" }, { default: w(({ row: o }) => {
      var t;
      return [b("span", null, k(o.quantity) + " | " + k((t = o.totalNetWeight) == null ? void 0 : t.toFixed(2)), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[c, f.value]])], 64);
  };
} }, Q = G(A, [["__scopeId", "data-v-324f39b1"]]);
export {
  Q as default
};
