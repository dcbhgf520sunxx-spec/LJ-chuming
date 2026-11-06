import { ref as u } from "vue";
import { nextTick as oe } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as z } from "vue";
import { createBlock as ae } from "vue";
import { withCtx as f } from "vue";
import { createVNode as d } from "vue";
import { createTextVNode as le } from "vue";
import { unref as b } from "vue";
import { createElementVNode as _ } from "vue";
import { createElementBlock as ne } from "vue";
import { createCommentVNode as ie } from "vue";
import { withKeys as se } from "vue";
import { isRef as ue } from "vue";
import { ElNotification as ce } from "element-plus";
import { ElInput as re } from "element-plus";
import { ElFormItem as de } from "element-plus";
import { ElForm as me } from "element-plus";
import { h as pe, i as ve } from "../../../../../../modules/inspection-config-a69d9e2f.js";
import { A as fe } from "../../../../../../modules/index-df3c71c0.js";
import { d as ge } from "../../../../../../modules/inspection-manage-c10227da.js";
import { _ as ye, u as he, o as _e, mO as we, S as ke } from "../../../../../../shared/runtime.js";
import { _ as xe } from "../../../../../../modules/PicUpload-8580ccfc.js";
const Ce = { style: { display: "flex", "flex-direction": "column", width: "100%" } }, be = { style: { position: "relative", margin: "-10px 0 20px 30px" } }, Ve = { key: 0, id: "pannel", class: "pannel" }, Ae = { class: "info" }, Me = { class: "input-item" }, Ee = { __name: "inspection-point-dlg", props: { visible: { type: Boolean, default: false }, isEdit: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) }, point: { type: String, default: "" } }, emits: ["update:visible", "edit-success"], setup(B, { emit: j }) {
  const V = u([]), D = u(), I = u(), w = u(), k = u(), x = u([]), g = u(), P = j, p = B, { visible: A, handleClose: G } = he({ emit: P, props: p, field: "visible", showHook: W, closeHook: Q }), { maxHeight: q } = _e({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"] }, A), N = u(false), H = u(), e = u({ name: void 0, point: void 0, inspectionAttachmentList: [] }), y = u(""), C = u(), M = u(false), $ = u(true), J = u({ name: [{ required: true, message: "请输入巡检点名称", trigger: "blur" }, { max: 10, message: "最多输入10个字符", trigger: "blur" }], pointName: [{ required: true, message: "请选择定位", trigger: "blur" }], aroundRadius: [{ required: true, message: "请输入巡检半径", trigger: "blur" }, { validator: (i, n, t) => {
    n > 10001 ? t(new Error("巡检半径必须大于0并且不可超过10000")) : t();
  }, message: "巡检半径必须大于0并且不可超过10000" }] });
  function W() {
    p.isEdit ? (e.value = p.data, e.value.inspectionAttachmentList = e.value.attachmentDTO ? [e.value.attachmentDTO] : []) : e.value = { name: void 0 }, O();
  }
  async function O() {
    try {
      const i = await ge({ type: we.JS.V }) || {};
      console.log(i, "DATA"), D.value = i == null ? void 0 : i.key, I.value = i == null ? void 0 : i.secret, oe(() => {
        Z(D.value, I.value);
      });
    } catch (i) {
      console.log("获取访问key值失败", i);
    }
  }
  function Q() {
    y.value = "", M.value = false;
  }
  function X(i) {
    i || (y.value = "", M.value = false, $.value = true, O());
  }
  function Y() {
    y.value && C.value.search(y.value);
  }
  function Z(i, n) {
    window._AMapSecurityConfig = { securityJsCode: n }, fe.load({ key: i, version: "2.0", plugins: ["AMap.ToolBar", "AMap.Scale", "AMap.HawkEye", "AMap.Geolocation", "AMap.MapType", "AMap.MouseTool", "AMap.Geocoder", "AMap.Circle"] }).then((t) => {
      var F, U;
      const l = new t.Map("myContainer", { viewMode: "3D", zoom: 13 });
      t.plugin(["AMap.ToolBar", "AMap.Marker", "AMap.Scale", "AMap.HawkEye", "AMap.Geolocation", "AMap.MapType", "AMap.MouseTool", "AMap.ElasticMarker", "AMap.Geocoder", "AMap.Circle"], function() {
        var a = new t.ToolBar();
        l.addControl(a), l.addControl(new t.Scale()), l.addControl(new t.HawkEye()), l.plugin("AMap.Geolocation", function() {
          var o = new t.Geolocation({ enableHighAccuracy: true, timeout: 1e4, buttonOffset: new t.Pixel(10, 20), zoomToAccuracy: true });
          o.getCurrentPosition(function(v, r) {
            v === "complete" ? s(r) : m(r);
          }), t.Event.addListener(o, "complete", s), t.Event.addListener(o, "error", m);
          function s(v) {
            console.log(v, "message");
          }
          function m(v) {
            console.log(v.message, "111");
          }
          l.addControl(o);
        }), l.addControl(new t.MapType());
      });
      var h = { input: "input_id", output: "list" };
      t.plugin(["AMap.PlaceSearch", "AMap.AutoComplete"], function() {
        var a = new t.AutoComplete(h);
        C.value = new t.PlaceSearch({ pageSize: 3, pageIndex: 1, citylimit: true, map: l, panel: "pannel", autoFitView: true }), a.on("select", function(o) {
          C.value.setCity(o.poi.adcode), C.value.search(o.poi.name);
        }), M.value = true, C.value.on("selectChanged", R);
      });
      function R(a) {
        console.log(a, "data"), V.value.forEach((m) => m.setMap(null)), V.value = [];
        const o = a.selected.data, s = new t.Marker({ position: [o.location.lng, o.location.lat], map: l });
        V.value.push(s), l.setCenter([o.location.lng, o.location.lat]), g.value = a.selected.data.address, e.value.pointName = g.value, e.value.point = a.selected.data.location.lng + "," + a.selected.data.location.lat;
      }
      if (e.value.point && e.value.aroundRadius) {
        const a = (F = e.value.point) == null ? void 0 : F.split(",")[0], o = (U = e.value.point) == null ? void 0 : U.split(",")[1];
        l.setCenter([a, o]), E([a, o]), c([a, o], e.value.aroundRadius), console.log([a, o], "中心点");
      }
      t.plugin("AMap.Geocoder", function() {
        var a = new t.Geocoder({ city: "全国" });
        p.point && !e.value.point && a.getLocation(p.point, function(o, s) {
          o === "complete" && s.info === "OK" && (l.setCenter([s.geocodes[0].location.lng, s.geocodes[0].location.lat]), E([s.geocodes[0].location.lng, s.geocodes[0].location.lat]));
        });
      });
      function E(a) {
        console.log("添加标记", a);
        const o = new t.Marker({ position: a, content: '<div class="custom-content-marker"><img src="//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-red.png" /></div>', offset: [-12, -26] });
        o.setMap(l), V.value.push(o);
      }
      function S(a, o, s) {
        w.value == null ? (k.value != null && (l.remove([k.value]), k.value = null), w.value = new a.Marker({ offset: new a.Pixel(0, 0), position: [o, s] }), l.add(w.value), l.setFitView()) : (l.remove([w.value]), w.value = null, k.value = new a.Marker({ offset: new a.Pixel(0, 0), position: [o, s] }), l.add(k.value), l.setFitView());
      }
      function c([a, o], s) {
        console.log(a, o, "巡检半径");
        var m = new t.Circle({ center: [a, o], radius: s });
        l.add(m), l.setFitView([m]);
      }
      t.plugin("AMap.Geocoder", function() {
        var m, v;
        var a = new t.Geocoder({ city: "全国" }), o = new t.Marker();
        function s() {
          l.add(o), o.setPosition(x.value), a.getAddress(x.value, function(r, L) {
            r === "complete" && L.regeocode ? (g.value = L.regeocode.formattedAddress, e.value.pointName = g.value) : console.log("根据经纬度查询地址失败");
          });
        }
        if (l.on("click", function(r) {
          x.value = [r.lnglat.lng, r.lnglat.lat], e.value.point = r.lnglat.lng + "," + r.lnglat.lat, S(t, r.lnglat.KL, r.lnglat.kT), s();
        }), e.value.point && p.isEdit && !e.value.pointName) {
          const r = (m = e.value.point) == null ? void 0 : m.split(",")[0], L = (v = e.value.point) == null ? void 0 : v.split(",")[1];
          x.value = [r, L], a.getAddress(x.value, function(te, K) {
            te === "complete" && K.regeocode ? (g.value = K.regeocode.formattedAddress, e.value.pointName = g.value) : console.log("根据经纬度查询地址失败");
          });
        }
      });
    }).catch((t) => {
      console.log(t);
    });
  }
  async function ee() {
    var i, n;
    try {
      if (!await H.value.validate()) return;
      N.value = true, console.log(e.value.inspectionAttachmentList, "form.value.inspectionAttachmentList"), e.value.attachmentId = e.value.inspectionAttachmentList && ((i = e.value.inspectionAttachmentList) == null ? void 0 : i.length) > 0 ? (n = e.value.inspectionAttachmentList[0]) == null ? void 0 : n.id : void 0, p.isEdit ? await pe({ id: p.data.id, name: e.value.name, attachmentId: e.value.attachmentId, aroundRadius: e.value.aroundRadius, point: e.value.point, pointName: e.value.pointName }) : await ve({ name: e.value.name, attachmentId: e.value.attachmentId, aroundRadius: e.value.aroundRadius, point: e.value.point, pointName: e.value.pointName }), ce({ title: `${p.isEdit ? "修改" : "创建"}巡检点成功`, type: "success", duration: 2500 }), P("edit-success"), G();
    } catch (t) {
      console.error(t);
    } finally {
      N.value = false;
    }
  }
  return (i, n) => {
    const t = T("common-button"), l = re, h = de, R = T("common-input-number"), E = me, S = T("common-dialog");
    return z(), ae(S, { title: `巡检点${B.isEdit ? "修改" : "创建"}`, modelValue: b(A), "onUpdate:modelValue": n[5] || (n[5] = (c) => ue(A) ? A.value = c : null), "close-on-click-modal": false, top: "1vh", width: "1000px", "before-close": b(G) }, { titleRight: f(() => [d(t, { type: "primary", loading: N.value, onClick: ee }, { default: f(() => n[6] || (n[6] = [le(" 保 存 ")])), _: 1, __: [6] }, 8, ["loading"])]), default: f(() => [d(E, { ref_key: "formRef", ref: H, model: e.value, rules: J.value, "label-width": "120px", "max-height": b(q) }, { default: f(() => [d(h, { label: "巡检点名称", prop: "name" }, { default: f(() => [d(l, { modelValue: e.value.name, "onUpdate:modelValue": n[0] || (n[0] = (c) => e.value.name = c), placeholder: "巡检点名称", style: { width: "100%" }, clearable: "" }, null, 8, ["modelValue"])]), _: 1 }), d(h, { label: "巡检点定位", prop: "pointName" }, { default: f(() => [_("div", Ce, [d(l, { modelValue: e.value.pointName, "onUpdate:modelValue": n[1] || (n[1] = (c) => e.value.pointName = c), modelModifiers: { trim: true }, placeholder: "选择定位", style: { "margin-bottom": "10px" }, disabled: "" }, null, 8, ["modelValue"])])]), _: 1 }), _("div", be, [n[7] || (n[7] = _("div", { id: "myContainer", style: { height: "410px" } }, null, -1)), n[8] || (n[8] = _("div", { id: "list", class: "list" }, null, -1)), M.value ? (z(), ne("div", Ve)) : ie("", true), _("div", Ae, [_("div", Me, [d(l, { id: "input_id", type: "text", placeholder: "请输入关键字", clearable: "", autocomplete: "off", onInput: X, modelValue: y.value, "onUpdate:modelValue": n[2] || (n[2] = (c) => y.value = c), onKeyup: se(Y, ["enter"]) }, null, 8, ["modelValue"])])])]), d(h, { label: "巡检点图片", prop: "inspectionAttachmentList" }, { default: f(() => [d(b(xe), { files: e.value.inspectionAttachmentList, "onUpdate:files": n[3] || (n[3] = (c) => e.value.inspectionAttachmentList = c), "file-classify": b(ke).NORMAL.V, limit: 1 }, null, 8, ["files", "file-classify"])]), _: 1 }), d(h, { label: "巡检半径(米)", prop: "aroundRadius" }, { default: f(() => [d(R, { modelValue: e.value.aroundRadius, "onUpdate:modelValue": n[4] || (n[4] = (c) => e.value.aroundRadius = c), step: 1, min: 1, precision: 0, max: 1e4, controls: false, clearable: "", placeholder: "巡检点半径(米)", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "rules", "max-height"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, Ie = ye(Ee, [["__scopeId", "data-v-458a5673"]]);
export {
  Ie as default
};
