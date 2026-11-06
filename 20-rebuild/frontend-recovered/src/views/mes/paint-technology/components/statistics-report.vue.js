import { ref as y } from "vue";
import { computed as k } from "vue";
import { watch as X } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as a } from "vue";
import { Fragment as j } from "vue";
import { renderList as q } from "vue";
import { normalizeClass as Z } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as C } from "vue";
import { withDirectives as ee } from "vue";
import { createVNode as c } from "vue";
import { withCtx as f } from "vue";
import { unref as b } from "vue";
import { createBlock as B } from "vue";
import { createTextVNode as te } from "vue";
import { ElMessageBox as se } from "element-plus";
import { ElMessage as ae } from "element-plus";
import { ElFormItem as ne } from "element-plus";
import { ElCol as oe } from "element-plus";
import { ElRow as le } from "element-plus";
import { ElForm as ie } from "element-plus";
import { ElTableColumn as re } from "element-plus";
import { vLoading as ce } from "element-plus";
import { _ as ue, bY as pe, G as I, op as P, oq as de } from "../../../../shared/runtime.js";
import { l as me, c as W } from "./list-detail-dialog.vue.js";
const _e = { class: "statistics-report-container" }, ve = { class: "left-list-panel" }, fe = { class: "list-content" }, ge = ["onClick"], he = { class: "item-name" }, ye = { key: 0, class: "empty-list" }, be = { class: "right-report-panel" }, we = { class: "statistics-report" }, ke = { class: "report-header" }, Ce = { class: "header-info" }, Ne = { class: "consumption-cell cell-type" }, Te = { class: "k" }, Ee = { class: "v" }, xe = { key: 0 }, De = { class: "consumption-cell" }, Be = { class: "v" }, Ie = { class: "consumption-cell" }, Pe = { class: "v" }, Ve = { class: "consumption-cell" }, Ae = { class: "v" }, Le = { class: "consumption-cell" }, Re = { class: "v" }, Fe = { class: "consumption-cell cell-usage" }, je = { class: "v" }, qe = { class: "header-actions" }, We = { __name: "statistics-report", props: { rowData: { type: Object, default: null } }, emits: ["refresh"], setup(z, { emit: S }) {
  const V = z, U = S, $ = y(false), N = y(null), g = y([]), T = y(null), m = y(null), E = y(false), x = y(null), w = k(() => {
    var t;
    return (t = m.value) == null ? void 0 : t.id;
  }), M = k(() => {
    var t;
    return ((t = m.value) == null ? void 0 : t.serialNumber) || "";
  }), G = k(() => {
    var e;
    return (((e = N.value) == null ? void 0 : e.structureClassList) || []).map((s) => ({ structureClassId: s.structureClassId, structureClassName: s.structureClassName, quantity: s.quantity, totalWeight: s.totalWeight, totalArea: s.totalArea, average: s.average }));
  }), Q = k(() => {
    var o;
    const t = ((o = N.value) == null ? void 0 : o.paintCalculateConsumptionList) || [], e = /* @__PURE__ */ new Map();
    return t.forEach((n) => {
      const i = n.paintingTypeEnum;
      e.has(i) || e.set(i, []), e.get(i).push(n);
    }), [1, 2, 4].filter((n) => e.has(n)).map((n) => {
      var i, r;
      return { paintingTypeEnum: n, label: ((r = (i = pe) == null ? void 0 : i.VL) == null ? void 0 : r[n]) || (n === 1 ? "底漆" : n === 2 ? "中间漆" : "面漆"), items: e.get(n) || [] };
    });
  });
  function D(t) {
    const e = Number(t);
    return Number.isFinite(e) ? e : void 0;
  }
  function A(t, e = 2) {
    const s = D(t);
    return s == null ? "-" : s.toFixed(e);
  }
  const O = k(() => {
    const t = [];
    return Q.value.forEach((e) => {
      const s = e.items || [], o = s.find(Boolean) || {}, n = s.reduce((h, _) => h + (D(_ == null ? void 0 : _.paintWeight) || 0), 0), i = s.reduce((h, _) => h + (D(_ == null ? void 0 : _.groupQuantity) || 0), 0), r = o.packageUnit || "组", u = n > 0 || i > 0 ? `${A(n)}kg/${A(i)}${r}` : "-";
      t.push({ paintingTypeEnum: e.paintingTypeEnum, label: e.label, paintType: o.paintType, paintBrand: o.paintBrand, paintColor: o.paintColor, paintThickness: o.paintThickness, lossCoefficient: o.lossCoefficient, totalArea: o.totalArea, usageText: u });
    }), t;
  });
  async function L() {
    var e;
    const t = (e = V.rowData) == null ? void 0 : e.id;
    if (!t) {
      g.value = [];
      return;
    }
    try {
      const s = await W.getPaintCalculateRecordList({ paintTechnologyId: t });
      g.value = (s == null ? void 0 : s.content) || [], g.value.length > 0 ? R(g.value[0]) : (m.value = null, T.value = null, N.value = null);
    } catch (s) {
      console.log("获取工艺清单失败", s), g.value = [];
    }
  }
  function R(t) {
    m.value = t, T.value = t.id, N.value = t;
  }
  X(() => {
    var t;
    return (t = V.rowData) == null ? void 0 : t.id;
  }, () => {
    L();
  }, { immediate: true });
  function Y({ columns: t, data: e }) {
    const s = [];
    return t.forEach((o, n) => {
      if (n === 0) {
        s[n] = "合计";
        return;
      }
      if (n === 1) {
        s[n] = "求和";
        return;
      }
      if (o.label !== "操作") if (["quantity", "totalWeight", "totalArea"].includes(o.property)) {
        const i = e.map((r) => Number(r[o.property]));
        i.every((r) => isNaN(r)) ? s[n] = "求和" : s[n] = i.reduce((r, u) => {
          const h = Number(u);
          return isNaN(h) ? r : r + u;
        }, 0).toFixed(2);
      } else s[n] = "求和";
    }), s;
  }
  async function H() {
    try {
      await se.confirm("确定删除吗？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await W.delete([w.value]), ae.success("删除成功"), U("refresh"), L();
    } catch (t) {
      console.log("删除失败", t);
    }
  }
  function J(t) {
    var e, s, o, n, i, r;
    x.value = { id: w.value, projectId: (e = m.value) == null ? void 0 : e.projectId, projectName: (o = (s = m.value) == null ? void 0 : s.project) == null ? void 0 : o.name, createUserName: (n = m.value) == null ? void 0 : n.createUserName, serialNumber: (i = m.value) == null ? void 0 : i.serialNumber, createTime: (r = m.value) == null ? void 0 : r.createTime, structureClassId: t.structureClassId }, console.log(x.value, "row"), E.value = true;
  }
  return (t, e) => {
    const s = ne, o = oe, n = le, i = ie, r = F("common-button"), u = re, h = F("common-table"), _ = ce;
    return p(), v("div", _e, [a("div", ve, [e[1] || (e[1] = a("div", { class: "panel-title" }, "工艺清单列表", -1)), a("div", fe, [(p(true), v(j, null, q(g.value, (l) => (p(), v("div", { key: l.id, class: Z(["list-item", { active: T.value === l.id }]), onClick: (K) => R(l) }, [a("div", he, d(l.serialNumber || "-"), 1)], 10, ge))), 128)), g.value.length === 0 ? (p(), v("div", ye, "暂无工艺单")) : C("", true)])]), a("div", be, [ee((p(), v("div", we, [a("div", ke, [a("div", Ce, [e[9] || (e[9] = a("div", { class: "report-title" }, "油漆统计表", -1)), c(i, { "label-width": "100px", class: "info-form" }, { default: f(() => [c(n, { gutter: 20 }, { default: f(() => [c(o, { span: 6 }, { default: f(() => [c(s, { label: "工艺编号" }, { default: f(() => [a("span", null, d(M.value), 1)]), _: 1 })]), _: 1 }), c(o, { span: 24, class: "consumption-rows" }, { default: f(() => [(p(true), v(j, null, q(O.value, (l) => (p(), v("div", { key: l.paintingTypeEnum, class: "consumption-row" }, [a("div", Ne, [a("span", Te, d(l.label) + "：", 1), a("span", Ee, d(l.paintType || "-"), 1), l.paintColor ? (p(), v("span", xe, "（" + d(l.paintColor) + "）", 1)) : C("", true)]), a("div", De, [e[2] || (e[2] = a("span", { class: "k" }, "品牌：", -1)), a("span", Be, d(l.paintBrand || "-"), 1)]), a("div", Ie, [e[3] || (e[3] = a("span", { class: "k" }, "漆膜厚度：", -1)), a("span", Pe, d(l.paintThickness ?? "-"), 1), e[4] || (e[4] = a("span", { class: "u" }, "um", -1))]), a("div", Ve, [e[5] || (e[5] = a("span", { class: "k" }, "损耗系数：", -1)), a("span", Ae, d(l.lossCoefficient ?? "-"), 1)]), a("div", Le, [e[6] || (e[6] = a("span", { class: "k" }, "面积：", -1)), a("span", Re, d(l.totalArea ?? "-"), 1), e[7] || (e[7] = a("span", { class: "u" }, "m²", -1))]), a("div", Fe, [e[8] || (e[8] = a("span", { class: "k" }, "用量：", -1)), a("span", je, d(l.usageText), 1)])]))), 128))]), _: 1 })]), _: 1 })]), _: 1 })]), a("div", qe, [b(I)(b(P).statPrint) ? (p(), B(de, { key: 0, "api-key": "mesPaintTechnologyStatistics", params: { calculateRecordId: w.value }, size: "default", "btn-type": "warning", disabled: !w.value }, null, 8, ["params", "disabled"])) : C("", true), b(I)(b(P).statDel) ? (p(), B(r, { key: 1, type: "danger", size: "default", icon: "el-icon-delete", onClick: H, disabled: !w.value }, { default: f(() => e[10] || (e[10] = [te(" 删除 ")])), _: 1, __: [10] }, 8, ["disabled"])) : C("", true)])]), c(h, { data: G.value, style: { width: "100%" }, "show-summary": "", "summary-method": Y }, { default: f(() => [c(u, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), c(u, { prop: "structureClassName", label: "构件类型", "min-width": "150px" }), c(u, { prop: "quantity", label: "总数量", align: "center", "min-width": "100px" }), c(u, { prop: "totalWeight", label: "总重量(kg)", align: "center", "min-width": "120px" }), c(u, { prop: "totalArea", label: "总面积", align: "center", "min-width": "100px" }), c(u, { label: "操作", align: "center", width: "100", fixed: "right" }, { default: f(({ row: l }) => [b(I)(b(P).statDetail) ? (p(), B(r, { key: 0, type: "primary", size: "default", icon: "el-icon-view", onClick: (K) => J(l) }, null, 8, ["onClick"])) : C("", true)]), _: 1 })]), _: 1 }, 8, ["data"])])), [[_, $.value]])]), c(me, { modelValue: E.value, "onUpdate:modelValue": e[0] || (e[0] = (l) => E.value = l), "row-data": x.value, "api-type": "record" }, null, 8, ["modelValue", "row-data"])]);
  };
} }, $e = ue(We, [["__scopeId", "data-v-6527c32c"]]);
export {
  $e as default
};
