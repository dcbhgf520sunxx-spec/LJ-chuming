import { reactive as J } from "vue";
import { ref as u } from "vue";
import s from "moment";
import { watch as we } from "vue";
import { resolveComponent as Q } from "vue";
import { resolveDirective as ke } from "vue";
import { openBlock as R } from "vue";
import { createElementBlock as X } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as d } from "vue";
import { unref as t } from "vue";
import { createBlock as Z } from "vue";
import { createCommentVNode as ee } from "vue";
import { withCtx as V } from "vue";
import { toDisplayString as te } from "vue";
import { normalizeStyle as U } from "vue";
import { withDirectives as w } from "vue";
import { vShow as Y } from "vue";
import { withModifiers as M } from "vue";
import { withKeys as Ie } from "vue";
import { createTextVNode as oe } from "vue";
import { ElDatePicker as xe } from "element-plus";
import { ElTag as Ve } from "element-plus";
import { ElDivider as Oe } from "element-plus";
import { ElInput as Ce } from "element-plus";
import { vLoading as Le } from "element-plus";
import { l as W, _ as Se, jg as f, bo as k, B as be, p as N, D as O, aV as Ne, I as Ae, bb as Ee, nA as Re, E as Ye, a as Me } from "../../../../../shared/runtime.js";
import { u as We } from "../../../../../modules/use-chart-59e4b63c.js";
import { _ as ae } from "../../../../../modules/production-line-select-f08e245b.js";
function ze(g) {
  return W({ module: "mes", url: "workshop/artifact/summary/page", method: "get", params: g });
}
function De(g) {
  return W({ module: "mes", url: "workshop/year/mete/summary", method: "get", params: g });
}
function je(g) {
  return W({ module: "mes", url: "workshop/report", method: "get", params: g });
}
function Pe(g) {
  return W({ module: "mes", url: "workshop/mete/summary", method: "get", params: g });
}
const Je = { get: ze };
const Qe = { class: "head-container" }, Ue = { style: { width: "100%", height: "250px", display: "flex" } }, Ge = { id: "workshopDeliveryChart", style: { width: "100%", height: "250px" } }, qe = { __name: "header", emits: "zoomChangeSize", setup(g, { emit: le }) {
  const ne = le, z = J({ mete: 0 }), D = J({ mete: 0 }), p = u(), I = u(), A = u([]), _ = u(true), ie = { date: [s().startOf("month").valueOf(), s().valueOf()], startTime: s().startOf("month").valueOf(), endTime: s().valueOf(), type: f.ALL_YEAR.V, dateTime: s().startOf("year").valueOf(), projectId: void 0, workShopId: void 0, productionLineId: void 0, weightStatus: k.NET.V, name: void 0 }, E = u(), C = u(), { crud: n, query: e } = be(ie);
  function se(l) {
    l === f.ALL_YEAR.V ? e.dateTime = s().startOf("year").valueOf() : e.dateTime = s().startOf("month").valueOf(), h(), y(), n.toQuery();
  }
  const de = u([k.NET, k.GROSS]);
  function G(l) {
    return l > /* @__PURE__ */ new Date();
  }
  h(), L();
  async function h() {
    try {
      const l = await De({ type: e.type, dateTime: e.dateTime ? e.dateTime : s().startOf("year").valueOf(), workShopId: e.workShopId, productionLineId: e.productionLineId });
      z.mete = l;
    } catch (l) {
      console.log("获取全年产量失败", l);
    }
  }
  async function L() {
    try {
      const l = await Pe({ startTime: e.startTime ? e.startTime : s().startOf("month").valueOf(), endTime: e.endTime ? e.endTime : s().valueOf(), workShopId: e.workShopId, productionLineId: e.productionLineId, projectId: e.projectId });
      D.mete = l || {};
    } catch (l) {
      console.log("获取项目车间产量", l);
    }
  }
  function re() {
    L(), n.toQuery();
  }
  function ue() {
    h(), y(), n.toQuery();
  }
  function me() {
    e.productionLineId = C.value, E.value = C.value, h(), y(), n.toQuery();
  }
  function pe() {
    e.productionLineId = void 0, C.value = void 0, y(), e.productionLineId = E.value, h(), n.toQuery();
  }
  function ce() {
    h(), y(), n.toQuery();
  }
  function fe() {
    h(), y(), n.toQuery();
  }
  function q(l) {
    e.date && e.date.length > 1 ? (e.startTime = l[0], e.endTime = l[1]) : (e.startTime = void 0, e.endTime = void 0), L(), n.toQuery();
  }
  function he() {
    h(), L(), y(), n.toQuery();
  }
  function ye() {
    e.type = f.ALL_YEAR.V, e.dateTime = void 0, e.workShopId = void 0, e.productionLineId = void 0, e.weightStatus = k.NET.V, e.projectId = void 0, e.name = void 0, h(), L(), y(), n.toQuery();
  }
  const ve = u(), j = u([]);
  for (let l = 1; l <= 12; l++) j.value.push(l + "月");
  const K = u(), P = u([]);
  we([() => e.type, () => e.dateTime], (l) => {
    if (e.type === f.CURRENT_MONTH.V) {
      K.value = s(N(e.dateTime, "{y}-{m}"), "YYYY-MM").daysInMonth(), P.value = [];
      for (let o = 1; o <= K.value; o++) P.value.push(o);
    }
  });
  const F = u(false), H = u(false), { getMyChart: ge } = We({ elementId: "workshopDeliveryChart", fetchHook: y, initOption: { legend: { show: false }, xAxis: { data: j.value }, title: { text: "单位：吨", left: "90%", textStyle: { fontSize: 14 } }, yAxis: { axisTick: { show: false }, axisLine: { show: true }, splitLine: { show: true } }, series: [{ name: "产量", type: "bar", yAxisIndex: 0, data: [] }] } });
  async function y() {
    var l, o, S;
    A.value = [];
    try {
      const v = [];
      H.value = true;
      const x = ge();
      x.on("click", function(i) {
        if (I.value = n.query.dateTime === void 0 ? s().valueOf() : e.dateTime, n.query.type === f.ALL_YEAR.V) {
          let r = [];
          r = i.name.split(""), r.pop(), console.log(r), p.value = r.join(""), console.log(i.name), console.log(p.value);
        } else p.value = i.name, console.log(p.value);
        p.value = Number(p.value) < 10 ? "0" + p.value : p.value, n.query.type === f.ALL_YEAR.V ? (I.value = n.query.dateTime === void 0 ? s().valueOf() : e.dateTime, A.value = [s(N(I.value, "{y}") + "-" + p.value).startOf("month").valueOf(), s(N(I.value, "{y}") + "-" + p.value).endOf("month").valueOf()]) : A.value = [s(N(I.value, "{y}-{m}") + "-" + p.value).startOf("date").valueOf(), s(N(I.value, "{y}-{m}") + "-" + p.value).endOf("date").valueOf()], q(A.value);
      });
      const T = await je({ type: e.type, dateTime: e.dateTime ? e.dateTime : s().startOf("year").valueOf(), workShopId: e.workShopId, productionLineId: e.productionLineId }), c = x.getOption();
      n.query.type === f.CURRENT_MONTH.V ? c.xAxis[0].data = P.value : c.xAxis[0].data = j.value;
      for (let i = 0; i < ((l = c.xAxis[0].data) == null ? void 0 : l.length); i++) T.findIndex((r) => Number(r.date) === i + 1) > -1 ? v.push({ date: c.xAxis[0].data[i], totalNetWeight: (o = T[T.findIndex((r) => Number(r.date) === i + 1)]) == null ? void 0 : o.totalNetWeight, totalGrossWeight: (S = T[T.findIndex((r) => Number(r.date) === i + 1)]) == null ? void 0 : S.totalGrossWeight }) : v.push({ date: c.xAxis[0].data[i], totalNetWeight: 0, totalGrossWeight: 0 });
      c.series[0].data = v.map((i) => n.query.weightStatus === k.NET.V ? Number(((i == null ? void 0 : i.totalNetWeight) / 1e3).toFixed(O.COM_WT__KG)) : Number((i.totalGrossWeight / 1e3).toFixed(O.COM_WT__KG))), x.setOption(c);
    } catch (v) {
      console.log(v, "获取车间报表信息失败");
    } finally {
      H.value = false;
    }
  }
  function B() {
    _.value = !_.value, ne("zoomChangeSize", _.value);
  }
  return (l, o) => {
    const S = Q("common-radio-button"), v = xe, x = Ve, T = Oe, c = Me, i = Ce, r = Q("common-button"), _e = Q("print-table"), $ = Le, Te = ke("permission");
    return R(), X("div", Qe, [m("div", { style: U(_.value ? "display: block" : "display: none") }, [d(S, { modelValue: t(e).type, "onUpdate:modelValue": o[0] || (o[0] = (a) => t(e).type = a), options: t(f).ENUM, class: "filter-item", type: "enum", onChange: se }, null, 8, ["modelValue", "options"]), t(e).type === t(f).ALL_YEAR.V ? (R(), Z(v, { key: 0, modelValue: t(e).dateTime, "onUpdate:modelValue": o[1] || (o[1] = (a) => t(e).dateTime = a), type: "year", size: "default", class: "date-item filter-item", style: { width: "120px !important" }, placeholder: "选择年", format: "YYYY", "value-format": "x", "disabled-date": G, onChange: ce }, null, 8, ["modelValue"])) : ee("", true), t(e).type === t(f).CURRENT_MONTH.V ? (R(), Z(v, { key: 1, modelValue: t(e).dateTime, "onUpdate:modelValue": o[2] || (o[2] = (a) => t(e).dateTime = a), type: "month", size: "default", class: "date-item filter-item", style: { width: "120px !important" }, placeholder: "选择月", format: "YYYY-MM", "value-format": "x", "disabled-date": G, onChange: fe }, null, 8, ["modelValue"])) : ee("", true), d(Ne, { ref_key: "workshopInfRef", ref: ve, modelValue: t(e).workShopId, "onUpdate:modelValue": o[3] || (o[3] = (a) => t(e).workShopId = a), placeholder: "请选择车间", "factory-id": t(e).factoryId, style: { width: "200px" }, class: "filter-item", clearable: "", onChange: ue }, null, 8, ["modelValue", "factory-id"]), d(t(ae), { ref: "productionLineRef", class: "filter-item", modelValue: C.value, "onUpdate:modelValue": o[4] || (o[4] = (a) => C.value = a), "factory-id": t(e).factoryId, "workshop-id": t(e).workShopId, placeholder: "请选择生产线", style: { width: "200px" }, clearable: "", onChange: me }, null, 8, ["modelValue", "factory-id", "workshop-id"]), d(x, { class: "filter-item", size: "large" }, { default: V(() => {
      var a, b;
      return [o[10] || (o[10] = m("span", null, "全年累计产量（吨）", -1)), o[11] || (o[11] = m("span", null, "：", -1)), m("span", null, te(t(n).query.weightStatus === t(k).NET.V ? (((a = z.mete) == null ? void 0 : a.totalNetWeight) / 1e3).toFixed(t(O).COM_WT__KG) : (((b = z.mete) == null ? void 0 : b.totalGrossWeight) / 1e3).toFixed(t(O).COM_WT__KG)), 1)];
    }), _: 1, __: [10, 11] }), d(S, { type: "enum", modelValue: t(e).weightStatus, "onUpdate:modelValue": o[5] || (o[5] = (a) => t(e).weightStatus = a), options: de.value, class: "filter-item", style: { float: "right" }, onChange: t(n).toQuery }, null, 8, ["modelValue", "options", "onChange"])], 4), m("div", { style: U(_.value ? "display: block" : "display: none") }, [w((R(), X("div", Ue, [w(m("div", Ge, null, 512), [[$, F.value]])])), [[$, F.value]])], 4), d(T, { style: U(_.value ? "display: block" : "display: none"), class: "divider" }, null, 8, ["style"]), w(m("div", null, [d(v, { modelValue: t(e).date, "onUpdate:modelValue": o[6] || (o[6] = (a) => t(e).date = a), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: t(Ae), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px", "margin-right": "10px" }, class: "filter-item date-item", onChange: q }, null, 8, ["modelValue", "shortcuts"]), d(t(Ee), { modelValue: t(e).projectId, "onUpdate:modelValue": o[7] || (o[7] = (a) => t(e).projectId = a), class: "filter-item", onChange: re, clearable: "", style: { width: "300px" } }, null, 8, ["modelValue"]), d(t(ae), { ref: "productionLineRef", class: "filter-item", modelValue: E.value, "onUpdate:modelValue": o[8] || (o[8] = (a) => E.value = a), "factory-id": t(e).factoryId, "workshop-id": t(e).workShopId, placeholder: "请选择生产线", style: { width: "200px" }, clearable: "", onChange: pe }, null, 8, ["modelValue", "factory-id", "workshop-id"]), w(m("div", { class: "icon-box filter-item", style: { "vertical-align": "middle" }, onClick: M(B, ["stop"]) }, [d(c, { class: "icon", "icon-class": "comp-zoom" })], 512), [[Y, _.value]]), w(m("div", { class: "icon-box filter-item", style: { "vertical-align": "middle" }, onClick: M(B, ["stop"]) }, [d(c, { class: "icon", "icon-class": "comp-zoom-out" })], 512), [[Y, !_.value]])], 512), [[Y, t(n).searchToggle]]), d(t(Ye), null, { optLeft: V(() => [w(m("div", null, [d(i, { modelValue: t(e).name, "onUpdate:modelValue": o[9] || (o[9] = (a) => t(e).name = a), modelModifiers: { trim: true }, size: "default", placeholder: "输入产品名称搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: Ie(t(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), d(r, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: M(he, ["stop"]) }, { default: V(() => o[12] || (o[12] = [oe(" 搜索 ")])), _: 1, __: [12] }), d(r, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: M(ye, ["stop"]) }, { default: V(() => o[13] || (o[13] = [oe(" 重置 ")])), _: 1, __: [13] }), d(x, { type: "warning", class: "filter-item", size: "large" }, { default: V(() => {
      var a, b;
      return [o[14] || (o[14] = m("span", null, "项目累计产量（吨）", -1)), o[15] || (o[15] = m("span", null, "：", -1)), m("span", null, te(t(n).query.weightStatus === t(k).NET.V ? (((a = D.mete) == null ? void 0 : a.totalNetWeight) / 1e3).toFixed(t(O).COM_WT__KG) : (((b = D.mete) == null ? void 0 : b.totalGrossWeight) / 1e3).toFixed(t(O).COM_WT__KG)), 1)];
    }), _: 1, __: [14, 15] })], 512), [[Y, t(n).searchToggle]])]), viewLeft: V(() => [w(d(_e, { "api-key": "mesFactoryWorkshopReport", params: { startTime: t(e).startTime, endTime: t(e).endTime, projectId: t(e).projectId, workShopId: t(e).workShopId, productionLineId: t(e).productionLineId }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[Te, t(Re).print]])]), _: 1 })]);
  };
} }, Ke = Se(qe, [["__scopeId", "data-v-4d054318"]]), Xe = Object.freeze(Object.defineProperty({ __proto__: null, default: Ke }, Symbol.toStringTag, { value: "Module" }));
export {
  Je as c,
  Xe as h,
  Ke as m
};
