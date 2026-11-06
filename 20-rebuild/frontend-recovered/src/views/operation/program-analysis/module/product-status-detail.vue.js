import { ref as k } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as I } from "vue";
import { createBlock as V } from "vue";
import { withCtx as m } from "vue";
import { createVNode as h } from "vue";
import { createTextVNode as O } from "vue";
import { toDisplayString as j } from "vue";
import { unref as d } from "vue";
import { createCommentVNode as _ } from "vue";
import { createElementVNode as C } from "vue";
import { isRef as S } from "vue";
import { ElTag as B } from "element-plus";
import { ElTableColumn as H } from "element-plus";
import { j as L, k as P } from "../../../../modules/program-analysis-f1c6c876.js";
import { u as z, G as T, a3 as y, o as q, z as $, L as G } from "../../../../shared/runtime.js";
const Q = { __name: "product-status-detail", props: { visible: { type: Boolean, default: false }, chartObj: { type: Object, default: () => {
} }, query: { type: Object, default: () => {
} }, projectInfo: { type: Object, default: () => {
} }, detailData: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(n, { emit: v }) {
  const g = k([]), R = v, a = n, { visible: w, handleClose: x } = z({ emit: R, props: a, field: "visible", showHook: A });
  async function A() {
    var i, c, l, f, r, p;
    if (!T((i = a.permission) == null ? void 0 : i.detail)) return false;
    let u = [];
    try {
      u = await L({ projectId: (c = a.projectInfo) == null ? void 0 : c.id, branchCompanyId: (l = a.query) == null ? void 0 : l.branchCompanyId, taskType: ((f = a.chartObj) == null ? void 0 : f.name) === "构件生产" ? y.ARTIFACT.V : ((r = a.chartObj) == null ? void 0 : r.name) === "部件生产" ? y.ASSEMBLE.V : ((p = a.chartObj) == null ? void 0 : p.name) === "零件生产" ? y.MACHINE_PART.V : void 0 }) || [], u == null || u.forEach((e) => {
        var o, s, b;
        e.deepMete = ((o = a.chartObj) == null ? void 0 : o.name) === "构件生产" ? a.detailData.artifactDeepMete : ((s = a.chartObj) == null ? void 0 : s.name) === "部件生产" ? a.detailData.assembleDeepMete : ((b = a.chartObj) == null ? void 0 : b.name) === "零件生产" ? a.detailData.partDeepMete : 0, e.completeRate = e.deepMete && e.mete ? (e.mete / e.deepMete * 100).toFixed(2) : 0;
      });
    } catch (t) {
      console.log("获取生产状态详情失败", t);
    } finally {
      g.value = u;
    }
  }
  const { maxHeight: E } = q({ extraBox: [".head-container"], paginate: true });
  function F(u) {
    const { columns: i, data: c } = u, l = [];
    return i.forEach((f, r) => {
      var p;
      if (r === 0) {
        l[r] = "合计";
        return;
      }
      if (f.property === "mete") {
        const t = c.map((e) => e.mete);
        t.every((e) => isNaN(e)) || (l[r] = t.reduce((e, o) => {
          const s = Number(o);
          return isNaN(s) ? e : e + o;
        }, 0)), l[r] = (l[r] / 1e3).toFixed(0);
      }
      if (f.property === "completeRate") {
        const t = (p = c[0]) == null ? void 0 : p.deepMete, e = c.map((o) => o.mete);
        e.every((o) => isNaN(o)) || (l[r] = e.reduce((o, s) => {
          const b = Number(s);
          return isNaN(b) ? o : o + s;
        }, 0)), l[r] = t && l[r] ? (l[r] / t * 100).toFixed(2) + "%" : "0%";
      }
    }), l;
  }
  return (u, i) => {
    var p;
    const c = B, l = H, f = M("common-table"), r = M("common-drawer");
    return I(), V(r, { ref: "drawerRef", title: `${(p = n.chartObj) == null ? void 0 : p.name}统计详情`, modelValue: d(w), "onUpdate:modelValue": i[0] || (i[0] = (t) => S(w) ? w.value = t : null), direction: "rtl", "before-close": d(x), size: "50%" }, { titleAfter: m(() => [h(c, { effect: "plain", size: "large", type: "warning", class: "filter-item" }, { default: m(() => [O("项目： " + j(d($)(n.projectInfo.project) || "-"), 1)]), _: 1 }), h(c, { effect: "plain", size: "large", class: "filter-item" }, { default: m(() => {
      var t, e, o;
      return [O("清单量： " + j(((t = n.chartObj) == null ? void 0 : t.name) === "构件生产" ? (n.detailData.artifactDeepMete / 1e3).toFixed(0) : ((e = n.chartObj) == null ? void 0 : e.name) === "部件生产" ? (n.detailData.assembleDeepMete / 1e3).toFixed(0) : ((o = n.chartObj) == null ? void 0 : o.name) === "零件生产" ? (n.detailData.partDeepMete / 1e3).toFixed(0) : 0) + "吨", 1)];
    }), _: 1 })]), titleRight: m(() => {
      var t, e, o, s, b, D, N;
      return [d(T)((t = n.permission) == null ? void 0 : t.download) ? (I(), V(G, { key: 0, fn: d(P), params: { projectId: (e = a.projectInfo) == null ? void 0 : e.id, branchCompanyId: (o = a.query) == null ? void 0 : o.branchCompanyId, taskType: ((s = a.chartObj) == null ? void 0 : s.name) === "构件生产" ? d(y).ARTIFACT.V : ((b = a.chartObj) == null ? void 0 : b.name) === "部件生产" ? d(y).ASSEMBLE.V : ((D = a.chartObj) == null ? void 0 : D.name) === "零件生产" ? d(y).MACHINE_PART.V : void 0 }, disabled: !((N = g.value) != null && N.length) }, { default: m(() => i[1] || (i[1] = [O(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : _("", true)];
    }), content: m(() => [h(f, { ref: "tableRef", data: g.value, "max-height": d(E), style: { width: "100%" }, "show-empty-symbol": false, "show-summary": "", "summary-method": F }, { default: m(() => [h(l, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), h(l, { "show-overflow-tooltip": true, prop: "dateTime", label: "月份", align: "center" }), h(l, { "show-overflow-tooltip": true, prop: "mete", label: "累计生产（吨）", align: "center" }, { default: m(({ row: t }) => [C("span", null, j(t.mete ? (t.mete / 1e3).toFixed(0) : 0), 1)]), _: 1 }), h(l, { "show-overflow-tooltip": true, prop: "completeRate", label: "完成率", align: "center" }, { default: m(({ row: t }) => [C("span", null, j(t.completeRate + "%"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  Q as default
};
