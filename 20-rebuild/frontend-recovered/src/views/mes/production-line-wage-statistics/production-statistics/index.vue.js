import { ref as u } from "vue";
import y from "moment";
import { provide as M } from "vue";
import { computed as U } from "vue";
import { watch as H } from "vue";
import { onMounted as $ } from "vue";
import { resolveComponent as O } from "vue";
import { openBlock as V } from "vue";
import { createElementBlock as j } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as l } from "vue";
import { unref as r } from "vue";
import { withDirectives as q } from "vue";
import { createBlock as z } from "vue";
import { withCtx as v } from "vue";
import { toDisplayString as x } from "vue";
import { nextTick as A } from "vue";
import { ElNotification as G } from "element-plus";
import { ElDatePicker as K } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { vLoading as J } from "element-plus";
import { g as Q } from "../../../../modules/production-statistics-aa5db1ec.js";
import { t as W, o as X, x as Z, pm as P, G as ee, pn as te, aV as ae, a3 as D } from "../../../../shared/runtime.js";
import oe from "./module/header.vue.js";
import le from "./production-detail/index.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const ne = { class: "app-container" }, se = { class: "head-container" }, re = { style: { display: "flex" } }, ie = { style: { width: "35%" } }, ue = { style: { "margin-bottom": "8px" } }, _e = { __name: "index", setup(me) {
  const { decimalPrecision: b } = W(), E = u(), T = u([]), k = u({}), d = u([y().startOf("month").valueOf(), y().valueOf()]), p = u(y().startOf("month").valueOf().valueOf()), f = u(y().valueOf()), w = u(), { maxHeight: R } = X({ extraBox: [".head-container"], paginate: true }), I = { add: false, edit: false, del: false, download: false }, { crud: S } = Z({ title: "产量统计", sort: [], permission: { ...P }, optShow: { ...I }, hasPagination: true });
  M("permission", P);
  const C = U(() => ({ workshopId: w.value, startTime: p.value, endTime: f.value }));
  H(() => C.value, (a) => {
    k.value = {};
  }), $(() => {
    _();
  });
  async function _() {
    if (p.value === d.value[0] && p.value, f.value === d.value[1] && f.value, !!ee(P.get)) try {
      const { content: a } = await Q({ workshopId: w.value, startTime: p.value, endTime: f.value });
      T.value = a || [];
    } catch (a) {
      console.log("获取工序汇总信息失败", a);
    }
  }
  function B(a) {
    a ? (p.value = a[0], f.value = a[1], a[1] - a[0] > 24 * 60 * 60 * 1e3 * 31 ? (a = [], A(() => {
      d.value = [];
    }), G({ title: "选择日期间隔最大不能超过31天", type: "error", duration: 2e3 })) : _()) : _();
  }
  function F(a) {
    k.value = a;
  }
  function L(a) {
    const { columns: s, data: g } = a, o = [];
    return s.forEach((m, c) => {
      if (c === 0) {
        o[c] = "合计";
        return;
      }
      if (m.property === "mete") {
        const i = g.map((t) => Number(t[m.property]));
        let e = 0;
        i.every((t) => isNaN(t)) || (e = i.reduce((t, h) => {
          const N = Number(h);
          return isNaN(N) ? t : t + h;
        }, 0)), o[c] = e ? (e / 1e3).toFixed(2) : 0;
      }
      if (m.property === "price") {
        const i = g.map((t) => Number(t[m.property]));
        let e = 0;
        i.every((t) => isNaN(t)) || (e = i.reduce((t, h) => {
          const N = Number(h);
          return isNaN(N) ? t : t + h;
        }, 0)), o[c] = e == null ? void 0 : e.toFixed(b.value.mes);
      }
    }), o;
  }
  return (a, s) => {
    const g = K, o = Y, m = O("table-cell-tag"), c = O("common-table"), i = J;
    return V(), j("div", ne, [n("div", se, [l(r(oe))]), n("div", re, [n("div", ie, [n("div", ue, [l(g, { modelValue: d.value, "onUpdate:modelValue": s[0] || (s[0] = (e) => d.value = e), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: r(te), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px", "margin-right": "10px" }, class: "filter-item date-item", onChange: B }, null, 8, ["modelValue", "shortcuts"]), l(ae, { modelValue: w.value, "onUpdate:modelValue": s[1] || (s[1] = (e) => w.value = e), placeholder: "请选择车间", clearable: "", style: { width: "160px" }, class: "filter-item", onChange: _ }, null, 8, ["modelValue"])]), q((V(), z(c, { ref_key: "tableRef", ref: E, data: T.value, "highlight-current-row": "", "empty-text": "暂无数据", "max-height": r(R), "row-key": "projectId", style: { width: "100%" }, "show-summary": "", "summary-method": L, onRowClick: F }, { default: v(() => [l(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), l(o, { align: "center", key: "process.name", prop: "process.name", "show-overflow-tooltip": true, label: "工序", "min-width": "60px" }, { default: v((e) => {
      var t;
      return [l(m, { name: r(D).VL[e.row.taskTypeEnum], color: r(D).V[e.row.taskTypeEnum].COLOR, offset: 10 }, null, 8, ["name", "color"]), n("span", null, x((t = e.row.process) == null ? void 0 : t.name), 1)];
    }), _: 1 }), l(o, { align: "center", key: "mete", prop: "mete", "show-overflow-tooltip": true, label: "产量（吨）", "min-width": "60px" }, { default: v((e) => [n("span", null, x(e.row.mete ? (e.row.mete / 1e3).toFixed(2) : 0), 1)]), _: 1 }), l(o, { align: "center", key: "price", prop: "price", "show-overflow-tooltip": true, label: "工资总额（元）", "min-width": "60px" }, { default: v((e) => {
      var t;
      return [n("span", null, x((t = e.row.price) == null ? void 0 : t.toFixed(r(b).mes)), 1)];
    }), _: 1 }), l(o, { align: "center", key: "avgPrice", prop: "avgPrice", "show-overflow-tooltip": true, label: "平均单价（元/吨）", "min-width": "60px" }, { default: v((e) => [n("span", null, x(e.row.mete ? (e.row.price / (e.row.mete / 1e3)).toFixed(r(b).mes) : 0), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[i, r(S).loading]])]), s[2] || (s[2] = n("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 300px)" } }, null, -1)), l(le, { commonParams: C.value, "detail-row": k.value, style: { flex: "1", "overflow-x": "hidden" } }, null, 8, ["commonParams", "detail-row"])])]);
  };
} };
export {
  _e as default
};
