import { ref as d } from "vue";
import { reactive as le } from "vue";
import { watch as _ } from "vue";
import { resolveComponent as q } from "vue";
import { openBlock as E } from "vue";
import { createBlock as B } from "vue";
import { withCtx as r } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as g } from "vue";
import { createElementBlock as te } from "vue";
import { Fragment as ae } from "vue";
import { renderList as ie } from "vue";
import { unref as D } from "vue";
import { toDisplayString as se } from "vue";
import { createElementVNode as p } from "vue";
import { withKeys as re } from "vue";
import { isRef as de } from "vue";
import { ElMessage as G } from "element-plus";
import { ElNotification as ue } from "element-plus";
import { ElCheckbox as me } from "element-plus";
import { ElCheckboxGroup as pe } from "element-plus";
import { ElFormItem as ce } from "element-plus";
import { ElRadio as ge } from "element-plus";
import { ElRadioGroup as fe } from "element-plus";
import { ElTimePicker as ve } from "element-plus";
import { ElInput as ye } from "element-plus";
import { ElForm as Te } from "element-plus";
import { h as ke, i as be, s as we } from "../../../../../modules/attendance-report-ce8c4447.js";
import { A as Ve } from "../../../../../modules/index-df3c71c0.js";
import { _ as Se, u as _e, mO as Ce, n3 as he } from "../../../../../shared/runtime.js";
const xe = { style: { "margin-left": "20px" } }, Ae = { style: { "margin-top": "10px" } }, Me = { style: { "margin-left": "20px" } }, Ee = { style: { position: "relative" } }, De = { class: "info" }, Le = { class: "input-item" }, We = { __name: "normal-config", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible"], setup(I, { emit: z }) {
  const L = d(), W = d(), V = d([]), F = d([]), N = d([]), C = d(), b = d([]), O = d(), v = d(""), w = d(), h = d(false), R = d(true), K = z, U = I, { visible: x, handleClose: H } = _e({ emit: K, props: U, field: "visible", closeHook: J });
  async function J() {
    b.value = [], await M.value.resetFields(), v.value = "", h.value = false;
  }
  const A = { weekScope: [{ required: true, message: "请选择工作日", trigger: "blur" }], clockType: [{ required: true, message: "请选择打卡方式", trigger: "blur" }], punchTimes: [{ required: true, message: "请选择打卡次数", trigger: "blur" }], advanceTime: [{ required: true, message: "请选择离岗打卡最早可提前时间", trigger: "blur" }], delayTime: [{ required: true, message: "请选择返岗打卡最早可延迟时间", trigger: "blur" }] }, M = d(), e = le({ weekScope: [], clockType: void 0, punchTimes: void 0, afternoonWorkingTime: void 0, afternoonClosingTime: void 0, morningClosingTime: void 0, morningWorkingTime: void 0, advanceTime: void 0, delayTime: void 0, isSetAdvance: false, isSetDelay: false }), Q = d(false);
  _(() => U.visible, async (l) => {
    l && (await $(), await P());
  }, { immediate: true }), _(() => e.isSetAdvance, () => {
    e.isSetAdvance && (e.advanceTime = void 0), A.advanceTime[0].required = !e.isSetAdvance;
  }), _(() => e.isSetDelay, () => {
    e.isSetDelay && (e.delayTime = void 0), A.delayTime[0].required = !e.isSetDelay;
  }), _(() => e.punchTimes, () => {
    e.punchTimes === 2 && (e.afternoonWorkingTime = void 0, e.morningClosingTime = void 0);
  });
  async function P() {
    try {
      const l = await ke({ type: Ce.JS.V }) || {};
      L.value = l == null ? void 0 : l.key, W.value = l == null ? void 0 : l.secret, Z(L.value, W.value);
    } catch (l) {
      console.log("获取访问key值失败", l);
    }
  }
  function X(l) {
    if (!l) v.value = "", h.value = false, R.value = false, P();
    else {
      var o = document.querySelector("#list");
      o.addEventListener("wheel", function(t) {
        t.stopPropagation();
      });
    }
  }
  function Y() {
    v.value && w.value.search(v.value);
  }
  function Z(l, o) {
    window._AMapSecurityConfig = { securityJsCode: o }, Ve.load({ key: l, version: "2.0", plugins: ["AMap.ToolBar", "AMap.Scale", "AMap.HawkEye", "AMap.Geolocation", "AMap.MapType", "AMap.MouseTool", "AMap.Geocoder", "AMap.Circle", "AMap.ElectronicFence"] }).then((t) => {
      var T, S;
      const s = new t.Map("container", { viewMode: "3D", zoom: 13 });
      t.plugin(["AMap.ToolBar", "AMap.Marker", "AMap.Scale", "AMap.HawkEye", "AMap.Geolocation", "AMap.MapType", "AMap.MouseTool", "AMap.ElasticMarker", "AMap.Geocoder", "AMap.Circle", "AMap.ElectronicFence"], function() {
        var i = new t.ToolBar();
        s.addControl(i), s.addControl(new t.Scale()), s.addControl(new t.HawkEye()), s.plugin("AMap.Geolocation", function() {
          var k = new t.Geolocation({ enableHighAccuracy: true, timeout: 1e4, buttonOffset: new t.Pixel(10, 20), zoomToAccuracy: true });
          k.getCurrentPosition(function(j, Fe) {
          }), t.Event.addListener(k, "complete", oe), t.Event.addListener(k, "error", ne);
          function oe(j) {
          }
          function ne(j) {
          }
          s.addControl(k);
        }), s.addControl(new t.MapType()), new t.MouseTool(s).polygon();
      });
      var y = { input: "input_id", output: "list" };
      t.plugin(["AMap.PlaceSearch", "AMap.AutoComplete"], function() {
        var i = new t.AutoComplete(y);
        w.value = new t.PlaceSearch({ pageSize: 3, pageIndex: 1, citylimit: true, map: s, panel: "pannel", autoFitView: true }), i.on("select", function(n) {
          w.value.setCity(n.poi.adcode), w.value.search(n.poi.name);
        }), h.value = true, w.value.on("selectChanged", u);
      });
      function u(i) {
        V.value.forEach((k) => k.setMap(null)), V.value = [];
        const n = i.selected.data;
        s.setCenter([n.location.lng, n.location.lat]), O.value = i.selected.data.address, e.pointName = O.value, e.point = i.selected.data.location.lng + "," + i.selected.data.location.lat;
      }
      s.on("click", (i) => {
        F.value = [i.lnglat.lng, i.lnglat.lat], C.value = i.lnglat.lng + "," + i.lnglat.lat, b.value.push(C.value), N.value = C.value, c();
      });
      async function f(i) {
        const n = new t.Polygon({ path: i, strokeWeight: 1, strokeOpacity: 0.6, fillOpacity: 0.6, zIndex: 50 });
        s.add(n);
      }
      if (e != null && e.projectManageAttendanceFenceDTOList && ((T = e == null ? void 0 : e.projectManageAttendanceFenceDTOList) != null && T.length)) {
        const i = (S = e == null ? void 0 : e.projectManageAttendanceFenceDTOList) == null ? void 0 : S.map((n) => [n.lng, n.lat]);
        f(i), s.setFitView();
      }
      function c() {
        m(), new t.Marker({ position: F.value, offset: new t.Pixel(-13, -30), content: '<div style="width: 24px; height: 34px"><img style="width: 100%; height: 100%" src="//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-default.png" /></div>' }).setMap(s);
      }
      function m() {
        var i;
        (i = V.value) != null && i.length && s.remove(V.value);
      }
    }).catch((t) => {
      console.log(t);
    });
  }
  async function $() {
    try {
      const l = await be();
      l && Object.keys(l).length > 0 && (e.id = l.id, e.weekScope = l.weekScopeList, e.clockType = l.clockType, e.punchTimes = l.punchTimes, e.afternoonWorkingTime = l.afternoonWorkingTime, e.afternoonClosingTime = l.afternoonClosingTime, e.morningClosingTime = l.morningClosingTime, e.morningWorkingTime = l.morningWorkingTime, e.advanceTime = l.advanceTime, e.delayTime = l.delayTime, e.isSetAdvance = !l.isSetAdvance, e.isSetDelay = !l.isSetDelay, l.pointDTOList && l.pointDTOList.length > 0 && (e.projectManageAttendanceFenceDTOList = l.pointDTOList));
    } catch (l) {
      console.log(l, "获取考勤配置信息失败");
    }
  }
  async function ee() {
    var y, u, f;
    if (!await M.value.validate()) return;
    if (!e.afternoonWorkingTime && e.punchTimes !== 2 || !e.afternoonClosingTime || !e.morningClosingTime && e.punchTimes !== 2 || !e.morningWorkingTime) {
      G.error("请填写必选项");
      return;
    }
    const o = (y = b.value) == null ? void 0 : y.map((c, m) => ({ sort: m + 1, point: c })), t = (u = e == null ? void 0 : e.projectManageAttendanceFenceDTOList) == null ? void 0 : u.map((c, m) => ({ sort: m + 1, point: c.lng + "," + c.lat }));
    if (!o.length && !t.length) {
      G.error("请选择电子围栏范围");
      return;
    }
    await we({ ...e, points: b.value && ((f = b.value) == null ? void 0 : f.length) > 0 ? o : t, weekScope: e.weekScope.reduce((c, m) => c + m, 0), isSetAdvance: !e.isSetAdvance, isSetDelay: !e.isSetDelay }) && (ue({ title: "考勤设置保存成功", type: "success", duration: 2500 }), H());
  }
  return (l, o) => {
    const t = q("common-button"), s = me, y = pe, u = ce, f = ge, c = fe, m = ve, T = ye, S = Te, i = q("common-drawer");
    return E(), B(i, { title: "常规考勤规则设定", modelValue: D(x), "onUpdate:modelValue": o[12] || (o[12] = (n) => de(x) ? x.value = n : null), size: "52%", "close-on-click-modal": false, "before-close": D(H) }, { titleRight: r(() => [a(t, { onClick: ee, size: "mini", loading: Q.value, type: "success" }, { default: r(() => o[13] || (o[13] = [g("保存")])), _: 1, __: [13] }, 8, ["loading"])]), content: r(() => [a(S, { ref_key: "formRef", ref: M, model: e, rules: A, class: "demo-form" }, { default: r(() => [a(u, { label: "工作日", prop: "weekScope" }, { default: r(() => [a(y, { modelValue: e.weekScope, "onUpdate:modelValue": o[0] || (o[0] = (n) => e.weekScope = n), onChange: l.handleCheckedCitiesChange }, { default: r(() => [(E(true), te(ae, null, ie(D(he).ENUM, (n) => (E(), B(s, { key: n.K, label: n.V, value: n.V }, { default: r(() => [g(se(n.L), 1)]), _: 2 }, 1032, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "onChange"])]), _: 1 }), a(u, { label: "打卡方式", prop: "clockType" }, { default: r(() => [a(c, { modelValue: e.clockType, "onUpdate:modelValue": o[1] || (o[1] = (n) => e.clockType = n) }, { default: r(() => [a(f, { value: 1, label: 1 }, { default: r(() => o[14] || (o[14] = [g("手机定位打卡")])), _: 1, __: [14] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), a(u, { label: "打卡次数", prop: "clockType" }, { default: r(() => [a(c, { modelValue: e.punchTimes, "onUpdate:modelValue": o[2] || (o[2] = (n) => e.punchTimes = n) }, { default: r(() => [a(f, { value: 2, label: 2 }, { default: r(() => o[15] || (o[15] = [g("两次")])), _: 1, __: [15] }), a(f, { value: 4, label: 4 }, { default: r(() => o[16] || (o[16] = [g("四次")])), _: 1, __: [16] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), a(u, { label: "打卡时间", prop: "workingTime", class: "form-label-require" }, { default: r(() => [p("div", null, [p("span", null, [o[17] || (o[17] = g(" 上午上班 ")), a(m, { modelValue: e.morningWorkingTime, "onUpdate:modelValue": o[3] || (o[3] = (n) => e.morningWorkingTime = n), placeholder: "请选择时间", format: "HH:mm", "value-format": "x", style: { width: "200px" } }, null, 8, ["modelValue"])]), p("span", xe, [o[18] || (o[18] = g(" 上午下班 ")), a(m, { disabled: e.punchTimes === 2, modelValue: e.morningClosingTime, "onUpdate:modelValue": o[4] || (o[4] = (n) => e.morningClosingTime = n), placeholder: "请选择时间", format: "HH:mm", "value-format": "x", style: { width: "200px" } }, null, 8, ["disabled", "modelValue"])])]), p("div", Ae, [p("span", null, [o[19] || (o[19] = g(" 下午上班 ")), a(m, { disabled: e.punchTimes === 2, modelValue: e.afternoonWorkingTime, "onUpdate:modelValue": o[5] || (o[5] = (n) => e.afternoonWorkingTime = n), placeholder: "请选择时间", format: "HH:mm", "value-format": "x", style: { width: "200px" } }, null, 8, ["disabled", "modelValue"])]), p("span", Me, [o[20] || (o[20] = g(" 下午下班 ")), a(m, { modelValue: e.afternoonClosingTime, "onUpdate:modelValue": o[6] || (o[6] = (n) => e.afternoonClosingTime = n), placeholder: "请选择时间", format: "HH:mm", "value-format": "x", style: { width: "200px" } }, null, 8, ["modelValue"])])])]), _: 1 }), a(u, { label: "离岗打卡最早可提前", prop: "advanceTime" }, { default: r(() => [a(s, { modelValue: e.isSetAdvance, "onUpdate:modelValue": o[7] || (o[7] = (n) => e.isSetAdvance = n), label: "不限制", style: { "margin-right": "10px" } }, null, 8, ["modelValue"]), a(T, { modelValue: e.advanceTime, "onUpdate:modelValue": o[8] || (o[8] = (n) => e.advanceTime = n), style: { width: "200px" }, placeholder: "请输入", disabled: e.isSetAdvance }, null, 8, ["modelValue", "disabled"]), o[21] || (o[21] = g(" （单位：分钟） "))]), _: 1, __: [21] }), a(u, { label: "返岗打卡最早可延迟", prop: "delayTime" }, { default: r(() => [a(s, { modelValue: e.isSetDelay, "onUpdate:modelValue": o[9] || (o[9] = (n) => e.isSetDelay = n), label: "不限制", style: { "margin-right": "10px" } }, null, 8, ["modelValue"]), a(T, { modelValue: e.delayTime, "onUpdate:modelValue": o[10] || (o[10] = (n) => e.delayTime = n), style: { width: "200px" }, placeholder: "请输入", disabled: e.isSetDelay }, null, 8, ["modelValue", "disabled"]), o[22] || (o[22] = g(" （单位：分钟） "))]), _: 1, __: [22] }), a(u, { label: "设置电子围栏", prop: "points", class: "form-label-require" }), p("div", Ee, [o[23] || (o[23] = p("div", { style: { width: "950px", height: "400px", "margin-top": "10px" }, id: "container" }, null, -1)), o[24] || (o[24] = p("div", { id: "list", class: "list" }, null, -1)), o[25] || (o[25] = p("div", { id: "pannel", class: "pannel" }, null, -1)), p("div", De, [p("div", Le, [a(T, { id: "input_id", type: "text", placeholder: "请输入关键字搜索", clearable: l.isClear, autocomplete: "off", onInput: X, modelValue: v.value, "onUpdate:modelValue": o[11] || (o[11] = (n) => v.value = n), onKeyup: re(Y, ["enter"]) }, null, 8, ["clearable", "modelValue"])])])])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ge = Se(We, [["__scopeId", "data-v-937aa243"]]);
export {
  Ge as default
};
