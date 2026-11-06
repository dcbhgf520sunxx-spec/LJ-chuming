import { ref as d } from "vue";
import { watch as ve } from "vue";
import { resolveComponent as O } from "vue";
import { openBlock as I } from "vue";
import { createBlock as J } from "vue";
import { withCtx as i } from "vue";
import { unref as C } from "vue";
import { createTextVNode as ge } from "vue";
import { createCommentVNode as U } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as S } from "vue";
import { toDisplayString as fe } from "vue";
import { createElementBlock as Q } from "vue";
import { withKeys as be } from "vue";
import { isRef as ye } from "vue";
import { ElNotification as X } from "element-plus";
import { ElSwitch as Ce } from "element-plus";
import { ElFormItem as _e } from "element-plus";
import { ElForm as Te } from "element-plus";
import { ElTimePicker as ke } from "element-plus";
import { ElDescriptionsItem as we } from "element-plus";
import { ElDescriptions as Ve } from "element-plus";
import { ElInput as he } from "element-plus";
import { e as Me, f as Se, s as Y, h as Fe } from "../../../../../modules/attendance-manage-750617cc.js";
import { A as Ae } from "../../../../../modules/index-df3c71c0.js";
import { _ as Ee, u as Ie, u5 as Ne, G as je, aS as Z, au as D } from "../../../../../shared/runtime.js";
import { _ as Pe } from "../../../../../modules/subcontract-supplier-select-bab9e7f8.js";
const We = { key: 0, style: { position: "relative" } }, xe = { key: 0, id: "pannel", class: "pannel" }, Oe = { class: "info" }, Ue = { class: "input-item" }, De = { __name: "setting-dialog", props: { visible: { type: Boolean, default: false }, projectId: { type: [Number, String] }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(N, { emit: ee }) {
  const H = d(), L = d(), F = d([]), B = d([]), le = d([]), j = d(), T = d([]), q = d(), k = d(""), h = d(), A = d(false), oe = d(true), ae = ee, f = N, { visible: P, handleClose: G } = Ie({ emit: ae, props: f, field: "visible", closeHook: te });
  async function te() {
    T.value = [], await w.value.resetFields(), k.value = "", A.value = false;
  }
  const ne = { morningWorkingTime: [{ required: true, message: "请选择上午上班时间", trigger: "blur" }], morningClosingTime: [{ required: true, message: "请选择上午下班时间", trigger: "blur" }], afternoonWorkingTime: [{ required: true, message: "请选择下午上班时间", trigger: "blur" }], afternoonClosingTime: [{ required: true, message: "请选择下午上班时间", trigger: "blur" }], supplierScope: [{ required: true, message: "请选择分包单位", trigger: "blur" }], isOutScope: [{ required: true, message: "请选择是否允许迟到或早退", trigger: "blur" }], isNeedPicture: [{ required: true, message: "请选择是否每次打卡需拍照", trigger: "blur" }], isNeedFence: [{ required: true, message: "请选择是否使用电子围栏", trigger: "blur" }] }, w = d(), e = d({ afternoonClosingTime: void 0, afternoonWorkingTime: void 0, morningClosingTime: void 0, morningWorkingTime: void 0, supplierScope: [], isOutScope: null, isNeedPicture: null, isNeedFence: null }), W = d(false), ie = d(), u = d({ isClose: false });
  ve(() => f.visible, async (n) => {
    n && (await ce(), e.value.isNeedFence && await x());
  }, { deep: true, immediate: true });
  async function x() {
    try {
      const n = await Me({ type: Ne.JS.V }) || {};
      H.value = n == null ? void 0 : n.key, L.value = n == null ? void 0 : n.secret, de(H.value, L.value);
    } catch (n) {
      console.log("获取访问key值失败", n);
    }
  }
  function se(n) {
    if (!n) k.value = "", A.value = false, oe.value = false, x();
    else {
      var l = document.querySelector("#list");
      l.addEventListener("wheel", function(a) {
        a.stopPropagation();
      });
    }
  }
  function re() {
    k.value && h.value.search(k.value);
  }
  function ue(n) {
    const l = parseInt(n % 864e5 / 36e5), a = parseInt(n % (1e3 * 60 * 60) / (1e3 * 60));
    return l + "小时" + a + "分钟";
  }
  function de(n, l) {
    window._AMapSecurityConfig = { securityJsCode: l }, Ae.load({ key: n, version: "2.0", plugins: ["AMap.ToolBar", "AMap.Scale", "AMap.HawkEye", "AMap.Geolocation", "AMap.MapType", "AMap.MouseTool", "AMap.Geocoder", "AMap.Circle", "AMap.ElectronicFence"] }).then((a) => {
      var v, y, E, t, R;
      const r = new a.Map("container", { viewMode: "3D", zoom: 13 });
      a.plugin(["AMap.ToolBar", "AMap.Marker", "AMap.Scale", "AMap.HawkEye", "AMap.Geolocation", "AMap.MapType", "AMap.MouseTool", "AMap.ElasticMarker", "AMap.Geocoder", "AMap.Circle", "AMap.ElectronicFence"], function() {
        var s = new a.ToolBar();
        r.addControl(s), r.addControl(new a.Scale()), r.addControl(new a.HawkEye()), r.plugin("AMap.Geolocation", function() {
          var V = new a.Geolocation({ enableHighAccuracy: true, timeout: 1e4, buttonOffset: new a.Pixel(10, 20), zoomToAccuracy: true });
          V.getCurrentPosition(function(M, $) {
            M === "complete" ? z($) : K($);
          }), a.Event.addListener(V, "complete", z), a.Event.addListener(V, "error", K);
          function z(M) {
            console.log(M, "message");
          }
          function K(M) {
            console.log(M.message, "111");
          }
          r.addControl(V);
        }), r.addControl(new a.MapType()), new a.MouseTool(r).polygon();
      });
      var c = { input: "input_id", output: "list" };
      a.plugin(["AMap.PlaceSearch", "AMap.AutoComplete"], function() {
        var s = new a.AutoComplete(c);
        h.value = new a.PlaceSearch({ pageSize: 3, pageIndex: 1, citylimit: true, map: r, panel: "pannel", autoFitView: true }), s.on("select", function(p) {
          h.value.setCity(p.poi.adcode), h.value.search(p.poi.name);
        }), A.value = true, h.value.on("selectChanged", _);
      });
      function _(s) {
        console.log(s, "data"), F.value.forEach((V) => V.setMap(null)), F.value = [];
        const p = s.selected.data;
        r.setCenter([p.location.lng, p.location.lat]), q.value = s.selected.data.address, e.value.pointName = q.value, e.value.point = s.selected.data.location.lng + "," + s.selected.data.location.lat;
      }
      r.on("click", (s) => {
        B.value = [s.lnglat.lng, s.lnglat.lat], j.value = s.lnglat.lng + "," + s.lnglat.lat, T.value.push(j.value), le.value = j.value, m();
      });
      async function g(s) {
        const p = new a.Polygon({ path: s, strokeWeight: 1, strokeOpacity: 0.6, fillOpacity: 0.6, zIndex: 50 });
        r.add(p);
      }
      if ((v = e.value) != null && v.projectManageAttendanceFenceDTOList && ((E = (y = e.value) == null ? void 0 : y.projectManageAttendanceFenceDTOList) != null && E.length)) {
        const s = (R = (t = e.value) == null ? void 0 : t.projectManageAttendanceFenceDTOList) == null ? void 0 : R.map((p) => [p.lng, p.lat]);
        g(s), r.setFitView();
      }
      function m() {
        b(), new a.Marker({ position: B.value, offset: new a.Pixel(-13, -30), content: '<div style="width: 24px; height: 34px"><img style="width: 100%; height: 100%" src="//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-default.png" /></div>' }).setMap(r);
      }
      function b() {
        var s;
        (s = F.value) != null && s.length && r.remove(F.value);
      }
    }).catch((a) => {
      console.log(a);
    });
  }
  async function ce() {
    var n;
    try {
      const l = await Se({ projectId: f.projectId });
      e.value = l || {}, (n = e.value) != null && n.id ? u.value.isClose = e.value.isClose : u.value.isClose = false;
    } catch (l) {
      console.log(l, "获取考勤配置信息失败");
    }
  }
  async function me(n) {
    await w.value.validateField("isNeedFence"), n && await x();
  }
  async function pe() {
    var r, c, _, g, m, b;
    if (!await w.value.validate()) return;
    const l = (r = T.value) == null ? void 0 : r.map((v, y) => ({ sort: y + 1, point: v })), a = (_ = (c = e.value) == null ? void 0 : c.projectManageAttendanceFenceDTOList) == null ? void 0 : _.map((v, y) => ({ sort: y + 1, point: v.lng + "," + v.lat }));
    try {
      W.value = true, u.value.isClose ? await Y({ id: (g = e.value) == null ? void 0 : g.id, morningWorkingTime: e.value.morningWorkingTime, morningClosingTime: e.value.morningClosingTime, afternoonWorkingTime: e.value.afternoonWorkingTime, afternoonClosingTime: e.value.afternoonClosingTime, projectId: f.projectId, isClose: u.value.isClose }) : (m = e.value) != null && m.id ? await Y({ ...e.value, projectId: f.projectId, projectManageAttendanceFenceDTOParamList: e.value.isNeedFence ? { points: T.value && ((b = T.value) == null ? void 0 : b.length) > 0 ? l : a, projectId: f.projectId } : void 0, isClose: u.value.isClose }) : await Fe({ ...e.value, projectId: f.projectId, projectManageAttendanceFenceDTOParamList: e.value.isNeedFence ? { points: l, projectId: f.projectId } : void 0, isClose: u.value.isClose }), X({ title: "考勤设置保存成功", type: "success", duration: 2500 }), G(), T.value = [];
    } catch {
      X({ title: "考勤设置保存失败", type: "error", duration: 2500 });
    } finally {
      W.value = false;
    }
  }
  return (n, l) => {
    const a = O("common-button"), r = Ce, c = _e, _ = Te, g = ke, m = we, b = O("common-radio"), v = Ve, y = he, E = O("common-dialog");
    return I(), J(E, { title: "考勤设置", modelValue: C(P), "onUpdate:modelValue": l[12] || (l[12] = (t) => ye(P) ? P.value = t : null), top: "1vh", width: "1000px", "close-on-click-modal": false, "before-close": C(G) }, { titleRight: i(() => [C(je)(N.permission.save) ? (I(), J(a, { key: 0, onClick: pe, size: "default", loading: W.value, type: "success" }, { default: i(() => l[13] || (l[13] = [ge("保存")])), _: 1, __: [13] }, 8, ["loading"])) : U("", true)]), default: i(() => [o(_, { ref_key: "formAttadanceRef", ref: ie, model: u.value, class: "demo-form" }, { default: i(() => [o(c, { label: "关闭考勤", prop: "isClose" }, { default: i(() => [o(r, { modelValue: u.value.isClose, "onUpdate:modelValue": l[0] || (l[0] = (t) => u.value.isClose = t), "active-color": "#F56C6C", "inactive-color": "#67C23A", "active-value": C(Z).TRUE.V, "inactive-value": C(Z).FALSE.V }, null, 8, ["modelValue", "active-value", "inactive-value"])]), _: 1 })]), _: 1 }, 8, ["model"]), o(_, { ref_key: "formRef", ref: w, model: e.value, rules: ne, class: "demo-form" }, { default: i(() => [o(v, { class: "margin-top", column: 2, border: "" }, { default: i(() => [o(m, { label: "上午上班", "label-class-name": "my-label" }, { default: i(() => [o(c, { label: "", prop: "morningWorkingTime" }, { default: i(() => [o(g, { modelValue: e.value.morningWorkingTime, "onUpdate:modelValue": l[1] || (l[1] = (t) => e.value.morningWorkingTime = t), placeholder: "请选择时间", format: "HH:mm", class: "input-border-none", disabled: u.value.isClose, "value-format": "x", style: { width: "100%" } }, null, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 }), o(m, { label: "上午下班", "label-class-name": "my-label" }, { default: i(() => [o(c, { label: "", prop: "morningClosingTime" }, { default: i(() => [o(g, { modelValue: e.value.morningClosingTime, "onUpdate:modelValue": l[2] || (l[2] = (t) => e.value.morningClosingTime = t), placeholder: "请选择时间", format: "HH:mm", class: "input-border-none", disabled: u.value.isClose, "value-format": "x", style: { width: "100%" } }, null, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 }), o(m, { label: "下午上班", "label-class-name": "my-label" }, { default: i(() => [o(c, { label: "", prop: "afternoonWorkingTime" }, { default: i(() => [o(g, { modelValue: e.value.afternoonWorkingTime, "onUpdate:modelValue": l[3] || (l[3] = (t) => e.value.afternoonWorkingTime = t), placeholder: "请选择时间", format: "HH:mm", class: "input-border-none", disabled: u.value.isClose, "value-format": "x", style: { width: "100%" } }, null, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 }), o(m, { label: "下午下班", "label-class-name": "my-label" }, { default: i(() => [o(c, { label: "", prop: "afternoonClosingTime" }, { default: i(() => [o(g, { modelValue: e.value.afternoonClosingTime, "onUpdate:modelValue": l[4] || (l[4] = (t) => e.value.afternoonClosingTime = t), placeholder: "请选择时间", format: "HH:mm", class: "input-border-none", disabled: u.value.isClose, "value-format": "x", style: { width: "100%" } }, null, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 }), o(m, { label: "工作时间", "label-class-name": "my-label" }, { default: i(() => [o(c, { label: "", prop: "workTime" }, { default: i(() => [S("span", null, fe(e.value.morningWorkingTime && e.value.morningClosingTime && e.value.afternoonWorkingTime && e.value.afternoonClosingTime ? ue(e.value.morningClosingTime - e.value.morningWorkingTime + (e.value.afternoonClosingTime - e.value.afternoonWorkingTime)) : "-"), 1)]), _: 1 })]), _: 1 }), o(m, { label: "添加单位", "label-class-name": "my-label" }, { default: i(() => [o(c, { label: "", prop: "supplierScope" }, { default: i(() => [o(Pe, { modelValue: e.value.supplierScope, "onUpdate:modelValue": l[5] || (l[5] = (t) => e.value.supplierScope = t), projectId: N.projectId, multiple: "", clearable: "", disabled: u.value.isClose, class: "input-border-none", style: { width: "100%" } }, null, 8, ["modelValue", "projectId", "disabled"])]), _: 1 })]), _: 1 }), o(m, { label: "允许迟到或早退", "label-class-name": "my-label" }, { default: i(() => [o(c, { label: "", prop: "isOutScope" }, { default: i(() => [o(b, { modelValue: e.value.isOutScope, "onUpdate:modelValue": l[6] || (l[6] = (t) => e.value.isOutScope = t), options: C(D).ENUM, disabled: u.value.isClose, type: "enum", onChange: l[7] || (l[7] = (t) => w.value.validateField("isOutScope")) }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })]), _: 1 }), o(m, { label: "每次打卡需拍照", "label-class-name": "my-label" }, { default: i(() => [o(c, { label: "", prop: "isNeedPicture" }, { default: i(() => [o(b, { modelValue: e.value.isNeedPicture, "onUpdate:modelValue": l[8] || (l[8] = (t) => e.value.isNeedPicture = t), options: C(D).ENUM, disabled: u.value.isClose, type: "enum", onChange: l[9] || (l[9] = (t) => w.value.validateField("isNeedPicture")) }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })]), _: 1 }), o(m, { label: "电子围栏", span: 2, "label-class-name": "my-label" }, { default: i(() => [o(c, { label: "", prop: "isNeedFence" }, { default: i(() => [o(b, { modelValue: e.value.isNeedFence, "onUpdate:modelValue": l[10] || (l[10] = (t) => e.value.isNeedFence = t), options: C(D).ENUM, disabled: u.value.isClose, type: "enum", onChange: me }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })]), _: 1 })]), _: 1 }), e.value.isNeedFence ? (I(), Q("div", We, [l[14] || (l[14] = S("div", { style: { width: "950px", height: "450px", "margin-top": "10px" }, id: "container" }, null, -1)), l[15] || (l[15] = S("div", { id: "list", class: "list" }, null, -1)), A.value ? (I(), Q("div", xe)) : U("", true), S("div", Oe, [S("div", Ue, [o(y, { id: "input_id", type: "text", placeholder: "请输入关键字搜索", clearable: n.isClear, autocomplete: "off", onInput: se, modelValue: k.value, "onUpdate:modelValue": l[11] || (l[11] = (t) => k.value = t), onKeyup: be(re, ["enter"]) }, null, 8, ["clearable", "modelValue"])])])])) : U("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ze = Ee(De, [["__scopeId", "data-v-40ab6e61"]]);
export {
  ze as default
};
