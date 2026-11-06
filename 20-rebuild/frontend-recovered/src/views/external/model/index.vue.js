import { useRoute as N } from "vue-router";
import { ref as o } from "vue";
import { computed as I } from "vue";
import { watch as U } from "vue";
import { onBeforeUnmount as B } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as A } from "vue";
import { Fragment as O } from "vue";
import { renderList as P } from "vue";
import { createCommentVNode as S } from "vue";
import { createVNode as K } from "vue";
import { withCtx as R } from "vue";
import { createTextVNode as F } from "vue";
import { toDisplayString as k } from "vue";
import { ElMessage as G } from "element-plus";
import { ElTag as j } from "element-plus";
import { normalizeClass as q } from "vue";
import { l as W, _ as Q, n as X, i as Y } from "../../../shared/runtime.js";
import { i as $, g as H, a as Z, b as J, c as ee, d as ae, e as te, f as oe } from "../../../modules/bimfaceAPI-c2661893.js";
function se(x, y) {
  return W({ url: `${x}/api/largeScreen/getModelInfoByFileId`, method: "get", params: y });
}
const ne = { id: "main-container" }, ie = { class: "app-model-container" }, re = { key: 0, class: "button-wrap" }, le = ["onClick"], ce = { key: 1, class: "tip-box" }, ue = { key: 2, id: "modelView" }, ve = { __name: "index", setup(x) {
  const y = N(), n = { PROCESSING_NO: { L: "3D模型未集成", K: "PROCESSING_NO", V: "processing_no", T: "warning" }, PROCESSING: { L: "3D模型正在转换，请稍后刷新重试", K: "PROCESSING", V: "processing", T: "warning" }, SUCCESS: { L: "成功", K: "SUCCESS", V: "success", T: "success" }, FAILED: { L: "3D模型转换失败，请联系管理员或重新上传", K: "FAILED", V: "failed", T: "danger" }, QUERY: { L: "查询中...", K: "QUERY", V: "query", T: "primary" }, MISSING: { L: "参数缺失，查询失败", K: "MISSING", V: "missing", T: "warning" }, UNEXIST: { L: "未上传3D模型", K: "UNEXIST", V: "unexist", T: "info" }, UPLOAD_PROCESSING: { L: "模型正在上传", K: "UPLOAD_PROCESSING", V: "uploadProcessing", T: "warning" }, UPLOAD_SUCCESS: { L: "模型未转换", K: "UPLOAD_SUCCESS", V: "uploadSuccess", T: "info" }, UPLOAD_FAILED: { L: "模型上传失败", K: "UPLOAD_FAILED", V: "uploadFailed", T: "danger" } };
  X(n);
  const w = o(), t = o(), s = o(), u = o(), g = o(), i = o([]), v = o({ fileId: "", status: "query", viewToken: "" }), r = o(n.QUERY.V), p = o(0), _ = o([{ name: "正面", value: { name: "persp", position: { x: 171.99075760854674, y: -15.391350034282624, z: 152.54541292963427 }, target: { x: 929.380242073717, y: 2423.8089822370894, z: -1908.326643164817 }, up: { x: 0.18621727045506586, y: 0.5997147603777349, z: 0.7782450349146733 }, near: 0.21709201041909434, far: 1545.341286089034, zoom: 4.548904719074391, version: 1, fov: 45, aspect: 2.3673076923076923, coordinateSystem: "world" } }, { name: "主干道", value: { name: "persp", position: { x: 171.154035384427, y: 43.727673752221065, z: 12.549368200061702 }, target: { x: 1123.6670051151998, y: 3167.5316674890983, z: -311.6394269956372 }, up: { x: 0.028812214303061252, y: 0.09448710620770526, z: 0.9951090608910403 }, near: 0.21709201041907783, far: 1756.3522655883291, zoom: 15.966612954237787, version: 1, fov: 45, aspect: 2.3673076923076923, coordinateSystem: "world" } }, { name: "十字路口", value: { name: "persp", position: { x: 206.16760753916435, y: 155.35643981990083, z: 2.678801893325513 }, target: { x: 1131.2234090995528, y: 3303.969997349961, z: 34.85259651164435 }, up: { x: -0.00276247161759803, y: -0.009406301388149282, z: 0.9999519439676875 }, near: 0.21709201041905127, far: 1636.4999390922596, zoom: 150.31111184424995, version: 1, fov: 45, aspect: 2.3673076923076923, coordinateSystem: "world" } }, { name: "背面", value: { name: "persp", position: { x: 365.01941858196045, y: 501.72222565591625, z: 249.5491420854246 }, target: { x: -264.6506030141447, y: -1544.3251550768643, z: -2237.9669892035186 }, up: { x: -0.22294211087979623, y: -0.7244328809367975, z: 0.6522988703148831 }, near: 0.2170920104191613, far: 1058.069368826025, zoom: 1.9132374488635353, version: 1, fov: 45, aspect: 2.3673076923076923, coordinateSystem: "world" } }, { name: "左侧", value: { name: "persp", position: { x: -13.809337234099722, y: 330.5027892649982, z: 164.78470317352242 }, target: { x: 2497.682712879007, y: -440.14556224585095, z: -1802.2027203388704 }, up: { x: 0.5729838672818774, y: -0.175824007599945, z: 0.8004844821645192 }, near: 0.21709201041909074, far: 1624.2097080685296, zoom: 81.68153043540985, version: 1, fov: 45, aspect: 2.3673076923076923, coordinateSystem: "world" } }, { name: "右侧", value: { name: "persp", position: { x: 619.9434711654932, y: 164.12513567223382, z: 148.02857030709887 }, target: { x: -1960.0548900325814, y: 948.72999527131, z: -1722.4083824480826 }, up: { x: -0.5452781780806435, y: 0.16582040570569334, z: 0.8216905144643287 }, near: 0.21709201041904855, far: 1311.886999828111, zoom: 1.326241710336435, version: 1, fov: 45, aspect: 2.3673076923076923, coordinateSystem: "world" } }, { name: "俯视", value: { name: "persp", position: { x: 238.72595094508185, y: 250.62483776141917, z: 480.93584736745646 }, target: { x: 242.8634840016967, y: 264.3312737199932, z: -2800.8815970000865 }, up: { x: 0.28921838698406643, y: 0.9572532019036534, z: 0.0043625767086145064 }, near: 418.408770637194, far: 509.3180862266013, zoom: 0.7379570652336586, version: 1, fov: 45, aspect: 2.3673076923076923, coordinateSystem: "world" } }]), C = I(() => {
    var e;
    if (Y((e = y.query) == null ? void 0 : e.fileId)) return Number(y.query.fileId);
  }), T = I(() => window.location.href.split("/external/model")[0]);
  U(() => C.value, (e) => {
    V(), L(e);
  }, { immediate: true }), B(() => {
    h();
  });
  function V() {
    h(), i.value = {}, v.value = { fileId: "", status: "query", viewToken: "" };
  }
  function h() {
    var e;
    (e = t.value) != null && e.view && t.value.destroy();
  }
  async function L(e) {
    try {
      e ? (i.value = await se(T.value, { fileId: e }) || {}, v.value = { fileId: i.value.fileId, viewToken: i.value.viewToken, status: i.value.status }, D(v.value.viewToken)) : (i.value = {}, r.value = n.MISSING.V);
    } catch (a) {
      i.value = {}, r.value = n.UNEXIST.V, console.log("获取模型viewToken", a);
    }
  }
  function M() {
    const e = { viewer: t.value, style: "BlueSky", customizedImage: { front: "https://static.bimface.com/attach/0d178c31584d432f93b3df90832d6ba1_EnvMap_posz.jpg", back: "https://static.bimface.com/attach/c02b7114af6d4966b3f1fd7d483fcdd9_EnvMap_negz.jpg", left: "https://static.bimface.com/attach/6c2f5045467b4c51a4e506524e74a65c_EnvMap_negx.jpg", right: "https://static.bimface.com/attach/ec541f626f194a979d49ec5f52ca32bb_EnvMap_posx.jpg", top: "https://static.bimface.com/attach/01700a9a6f7542af8df76bc923b065b9_EnvMap_posy.jpg", bottom: "https://static.bimface.com/attach/031a2a1a51374fc88fe8acf1d490b7c0_EnvMap_negy.jpg" } };
    oe(e).enableSkyBox(true);
  }
  async function D(e) {
    try {
      const a = await $({ viewToken: e });
      s.value = H(), s.value.domElement = document.getElementById("modelView"), s.value.navigatorType = "Web", s.value.enableToggleContextMenuDisplay = false, s.value.enableWireframe = false, s.value.enableViewHouse = false, s.value.enableReplaceMaterial = false, s.value.Toolbars = [], g.value = Z(s.value), a.viewToken ? g.value.addView(a.viewToken) : g.value.addModel(a), r.value = v.value.status, t.value = g.value.getViewer(), w.value = J(), t.value.addEventListener(w.value.ViewAdded, async () => {
        const d = ee();
        d.time = 0.8, d.viewer = t.value, u.value = ae(d), z(0), t.value.hideComponentsById(["741"]), M(), t.value.lockAxis(te(), [0, Math.PI / 2]), t.value.render();
      }, { passive: false });
    } catch (a) {
      console.log("加载模型失败", a), G.error("加载模型失败，请刷新重试");
    }
  }
  function z(e) {
    if (u.value.stop(), u.value.clearKeyFrames(), (p.value === 1 || p.value === 2) && p.value + e === 3) t.value.setCameraStatus(_.value[e].value);
    else {
      const a = [{ name: "persp", position: { x: 40.860117905227426, y: 32.36410583927067, z: 148.56024204530684 }, target: { x: 1935.6363336908712, y: 1927.1472815137968, z: -1746.2090138258889 }, up: { x: 0, y: -36732051030000714e-22, z: 0.9999999999932537 }, near: 0.21709201041913276, far: 1832.5996653812253, zoom: 7.454464988180051, version: 1, fov: 45, aspect: 2.3673076923076923, coordinateSystem: "world" }];
      a.push(_.value[e].value), u.value.setKeyFrames(a), u.value.play();
    }
    p.value = e;
  }
  return (e, a) => {
    var b, E;
    const d = j;
    return l(), c("div", ne, [A("div", ie, [t.value ? (l(), c("div", re, [(l(true), c(O, null, P(_.value, (m, f) => (l(), c("div", { key: m.name, class: q({ "button-active": f === p.value }), onClick: (pe) => z(f) }, k(m.name), 11, le))), 128))])) : S("", true), r.value !== n.SUCCESS.V ? (l(), c("div", ce, [K(d, { type: (E = (b = n.V) == null ? void 0 : b[r.value]) == null ? void 0 : E.T, size: "large" }, { default: R(() => {
      var m, f;
      return [F(k((f = (m = n.V) == null ? void 0 : m[r.value]) == null ? void 0 : f.L), 1)];
    }), _: 1 }, 8, ["type"])])) : S("", true), v.value.viewToken ? (l(), c("div", ue)) : S("", true)])]);
  };
} }, ye = Q(ve, [["__scopeId", "data-v-a2cbcdb5"]]);
export {
  ye as default
};
