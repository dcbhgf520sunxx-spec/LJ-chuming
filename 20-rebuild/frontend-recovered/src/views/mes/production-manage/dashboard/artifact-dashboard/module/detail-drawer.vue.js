import { ref as S } from "vue";
import { computed as U } from "vue";
import { watch as K } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as s } from "vue";
import { createBlock as B } from "vue";
import { withCtx as o } from "vue";
import { createVNode as y } from "vue";
import { withDirectives as V } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as l } from "vue";
import { vShow as I } from "vue";
import { unref as d } from "vue";
import { createElementBlock as n } from "vue";
import { createCommentVNode as J } from "vue";
import { Fragment as m } from "vue";
import { ElRadioGroup as X } from "element-plus";
import { renderList as L } from "vue";
import { ElRadioButton as Y } from "element-plus";
import { createElementVNode as u } from "vue";
import { normalizeStyle as Z } from "vue";
import { ElCollapse as p } from "element-plus";
import { ElCollapseItem as T } from "element-plus";
import { normalizeClass as ee } from "vue";
import { isRef as te } from "vue";
import { ElCol as ae } from "element-plus";
import { ElRow as le } from "element-plus";
import { vLoading as se } from "element-plus";
import { _ as ie, u as oe, o as de, a3 as A, D as $, p as z } from "../../../../../../shared/runtime.js";
const re = { key: 0, style: { color: "red", "margin-left": "15px" } }, ne = { class: "main-container" }, ue = { style: { display: "flex" } }, ce = { class: "name" }, ye = { class: "quantity" }, fe = { class: "number" }, we = { class: "time" }, _e = { class: "order-number" }, ve = { style: { "margin-left": "200px" } }, Re = { class: "name" }, me = { class: "quantity" }, he = { class: "time" }, be = { key: 1, class: "red-tip" }, ge = { key: 1, class: "red-tip" }, ke = { __name: "detail-drawer", props: { detailRow: { type: Object, default: () => {
} }, visible: { type: Boolean, required: true }, productType: { type: Number, default: void 0 } }, emits: ["update:visible"], setup(t, { emit: M }) {
  const q = S(), W = S(false), h = S(0), j = M, R = t, Q = U(() => {
    var v, r;
    return ((v = R.detailRow) == null ? void 0 : v.completeQuantity) + "/" + ((r = R.detailRow) == null ? void 0 : r.compareQuantity);
  }), { visible: D, handleClose: G } = oe({ emit: j, props: R, field: "visible" }), { maxHeight: O } = de({ mainBox: ".board-drawer", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, q);
  return K(() => {
    var v, r;
    return (r = (v = R.detailRow) == null ? void 0 : v.processSummaryDetailsList) == null ? void 0 : r.length;
  }, (v) => {
    var r, c;
    h.value = 0, (c = (r = R.detailRow) == null ? void 0 : r.processSummaryDetailsList) == null || c.forEach((b) => {
      var C, N;
      (C = b.teamTraceList) == null || C.forEach((f) => {
        var w;
        f.totalQuantity = (w = f.produceTeamRecourseList) == null ? void 0 : w.reduce((g, a) => a ? g + (a == null ? void 0 : a.quantity) : g, 0);
      }), b.sumQuantity = (N = b.teamTraceList) == null ? void 0 : N.reduce((f, w) => w ? f + (w == null ? void 0 : w.totalQuantity) : f, 0);
    });
  }, { immediate: true, deep: true }), (v, r) => {
    const c = ae, b = le, C = P("common-drawer"), N = se;
    return s(), B(C, { ref_key: "drawerRef", ref: q, title: `${t.detailRow.productType & d(A).ARTIFACT.V ? t.detailRow.name + " " + t.detailRow.serialNumber + " " + Q.value : t.detailRow.serialNumber + " " + Q.value}`, modelValue: d(D), "onUpdate:modelValue": r[1] || (r[1] = (f) => te(D) ? D.value = f : null), direction: "btt", "before-close": d(G), "custom-class": "board-drawer", size: "60%" }, { content: o(() => {
      var f, w, g;
      return [y(b, { ref: "contentTitle", class: "content-title" }, { default: o(() => [V(y(c, { span: 6 }, { default: o(() => [_("名称：" + l(t.detailRow.name || "-"), 1)]), _: 1 }, 512), [[I, t.detailRow.productType & d(A).ARTIFACT.V]]), y(c, { span: 6 }, { default: o(() => [_("编号：" + l(t.detailRow.serialNumber || "-"), 1)]), _: 1 }), y(c, { span: 6 }, { default: o(() => [_("规格：" + l(t.detailRow.specification || "-"), 1)]), _: 1 }), y(c, { span: 6 }, { default: o(() => [_("材质：" + l(t.detailRow.material || "-"), 1)]), _: 1 }), y(c, { span: 6 }, { default: o(() => [_("长度：" + l(t.detailRow.length || "-") + " mm", 1)]), _: 1 }), y(c, { span: 6 }, { default: o(() => {
        var a;
        return [_("单净重：" + l(((a = t.detailRow.netWeight) == null ? void 0 : a.toFixed(d($).COM_WT__KG)) || "-") + " kg", 1)];
      }), _: 1 }), y(c, { span: 6 }, { default: o(() => {
        var a;
        return [_("单毛重：" + l(((a = t.detailRow.grossWeight) == null ? void 0 : a.toFixed(d($).COM_WT__KG)) || "-") + " kg", 1)];
      }), _: 1 }), V(y(c, { span: 6 }, { default: o(() => [_("图号：" + l(t.detailRow.drawingNumber || "-"), 1)]), _: 1 }, 512), [[I, t.detailRow.productType & d(A).ARTIFACT.V]])]), _: 1 }, 512), R.productType === 16 ? (s(), n("span", re, " *该部件存在数量为" + l(t.detailRow.useComplete) + "的任务，通过利用后自动完成，无上报记录 ", 1)) : J("", true), V((s(), n("div", ne, [(w = (f = t.detailRow) == null ? void 0 : f.processSummaryDetailsList) != null && w.length ? (s(), n(m, { key: 0 }, [y(d(X), { modelValue: h.value, "onUpdate:modelValue": r[0] || (r[0] = (a) => h.value = a), size: "default", class: "filter-item" }, { default: o(() => {
        var a;
        return [(s(true), n(m, null, L((a = t.detailRow) == null ? void 0 : a.processSummaryDetailsList, (k, x) => (s(), B(d(Y), { key: x, value: x }, { default: o(() => [_(l(k.name) + "(" + l(k.sumQuantity || 0) + ") ", 1)]), _: 2 }, 1032, ["value"]))), 128))];
      }), _: 1 }, 8, ["modelValue"]), u("div", { class: "team-wrap", style: Z({ maxHeight: d(O) }) }, [(s(true), n(m, null, L((g = t.detailRow) == null ? void 0 : g.processSummaryDetailsList, (a, k) => {
        var x;
        return V((s(), n("div", { key: k }, [(x = a.teamTraceList) != null && x.length ? (s(true), n(m, { key: 0 }, L(a == null ? void 0 : a.teamTraceList, (i) => (s(), B(d(p), { key: i.name }, { default: o(() => {
          var F, H;
          return [y(d(T), { title: `${i == null ? void 0 : i.workshopName}>${i == null ? void 0 : i.productLineName}>${(H = (F = t.detailRow) == null ? void 0 : F.processSummaryDetailsList[h.value]) == null ? void 0 : H.name} / ${i.userName}`, name: `${i.userId}` }, { default: o(() => [u("div", ue, [u("div", null, [(s(true), n(m, null, L(i == null ? void 0 : i.produceTeamRecourseList, (e, E) => (s(), n("div", { key: E, class: "team-item" }, [u("div", ce, "生产：" + l((e == null ? void 0 : e.userName) || "-"), 1), u("div", ye, "数量：" + l((e == null ? void 0 : e.quantity) || "-"), 1), u("div", fe, "码号：" + l((e == null ? void 0 : e.number) || "-"), 1), u("div", we, "时间：" + l(d(z)(e == null ? void 0 : e.createTime, "{y}-{m}-{d} {h}:{i}:{s}") || "-"), 1), u("div", _e, "工单号：" + l((e == null ? void 0 : e.orderNumber) || "-"), 1)]))), 128))]), u("div", ve, [(s(true), n(m, null, L(i == null ? void 0 : i.InspectionTeamRecourseList, (e, E) => (s(), n("div", { key: E, class: "team-item" }, [u("div", Re, [u("i", { class: ee([e != null && e.boolAdoptEnum ? "is-success" : "is-error", e != null && e.boolAdoptEnum ? "el-icon-check" : "el-icon-close"]) }, null, 2), _(" 质检：" + l((e == null ? void 0 : e.userName) || "-"), 1)]), u("div", me, "数量：" + l((e == null ? void 0 : e.quantity) || "-"), 1), u("div", he, "时间：" + l(d(z)(e == null ? void 0 : e.createTime, "{y}-{m}-{d} {h}:{i}:{s}") || "-"), 1)]))), 128))])])]), _: 2 }, 1032, ["title", "name"])];
        }), _: 2 }, 1024))), 128)) : (s(), n("span", be, "* 暂无数据"))])), [[I, h.value === k]]);
      }), 128))], 4)], 64)) : (s(), n("span", ge, "* 暂无数据"))])), [[N, W.value]])];
    }), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, Ce = ie(ke, [["__scopeId", "data-v-dd8afb42"]]);
export {
  Ce as default
};
