import { ref as m } from "vue";
import { useStore as q } from "vuex";
import { computed as M } from "vue";
import { resolveComponent as E } from "vue";
import { resolveDirective as P } from "vue";
import { unref as r } from "vue";
import { openBlock as u } from "vue";
import { createBlock as w } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as d } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as C } from "vue";
import { createCommentVNode as y } from "vue";
import { withDirectives as W } from "vue";
import { Fragment as G } from "vue";
import { ElMessage as V } from "element-plus";
import { ElCheckbox as O } from "element-plus";
import { ElFormItem as T } from "element-plus";
import { ElForm as Z } from "element-plus";
import { ElCard as h } from "element-plus";
import { vLoading as A } from "element-plus";
import { _ as H, d as J, G as g, eZ as K, au as Q, eL as X, e_ as Y } from "../../../../../shared/runtime.js";
const $ = { key: 0, style: { float: "right" } }, ee = { key: 1 }, ae = { __name: "watermark", setup(le) {
  const p = X.watermark, x = { boolEnableWatermark: void 0, fontSize: 4, spacing: 35, transparency: 0.2, angle: -30 }, z = m(), S = q(), k = m(false), c = m(false), a = m({ ...x }), f = m({ ...x }), B = M(() => !J(a.value, f.value));
  D();
  async function D() {
    if (g(p.get)) {
      k.value = true;
      try {
        const { boolEnableWatermark: s, fontSize: e, spacing: i, transparency: _, angle: n } = await K() || {};
        f.value = { boolEnableWatermark: s, fontSize: e, spacing: i, transparency: _, angle: n }, a.value = { boolEnableWatermark: s, fontSize: e, spacing: i, transparency: _, angle: n };
      } catch (s) {
        console.log("error", s);
      } finally {
        k.value = false;
      }
    }
  }
  async function U() {
    if (a.value.boolEnableWatermark) {
      if (!a.value.fontSize) return V.error("请填写字体大小");
      if (!a.value.spacing) return V.error("请填写间距");
    }
    c.value = true;
    try {
      await Y(a.value), f.value = { ...a.value }, V.success("修改成功"), S.dispatch("config/fetchConfigInfo");
    } catch (s) {
      console.log("设置基础信息：水印信息", s);
    } finally {
      c.value = false;
    }
  }
  function F() {
    a.value = { ...f.value };
  }
  return (s, e) => {
    const i = E("common-button"), _ = O, n = T, v = E("common-input-number"), L = Z, N = h, I = P("empty-text"), R = A;
    return r(g)(r(p).get) ? (u(), w(N, { key: 0, class: "box-card", shadow: "hover" }, { header: o(() => [e[7] || (e[7] = d("span", { class: "title" }, "水印配置", -1)), r(g)(r(p).edit) && B.value ? (u(), b("div", $, [l(i, { size: "default", type: "warning", onClick: F }, { default: o(() => e[5] || (e[5] = [C("取消修改")])), _: 1, __: [5] }), l(i, { loading: c.value, size: "default", type: "success", onClick: U }, { default: o(() => e[6] || (e[6] = [C("保存")])), _: 1, __: [6] }, 8, ["loading"])])) : y("", true)]), default: o(() => [W((u(), b("div", null, [l(L, { ref_key: "formRef", ref: z, model: a.value }, { default: o(() => [l(n, { label: "页面增加人名水印", prop: "boolEnableWatermark" }, { default: o(() => {
      var t;
      return [r(g)(r(p).edit) ? (u(), w(_, { key: 0, modelValue: a.value.boolEnableWatermark, "onUpdate:modelValue": e[0] || (e[0] = (j) => a.value.boolEnableWatermark = j) }, null, 8, ["modelValue"])) : W((u(), b("span", ee, null, 512)), [[I, (t = r(Q)) == null ? void 0 : t.VL[a.value.boolEnableWatermark]]])];
    }), _: 1 }), a.value.boolEnableWatermark ? (u(), b(G, { key: 0 }, [l(n, { label: "水印-字体大小", prop: "fontSize" }, { default: o(() => [l(v, { class: "input-underline", controls: false, style: { width: "150px" }, precision: 2, step: 0.1, modelValue: a.value.fontSize, "onUpdate:modelValue": e[1] || (e[1] = (t) => a.value.fontSize = t) }, null, 8, ["modelValue"]), e[8] || (e[8] = d("span", null, "mm", -1))]), _: 1, __: [8] }), l(n, { label: "水印-字体透明度", prop: "transparency" }, { default: o(() => [l(v, { class: "input-underline", controls: false, style: { width: "136px" }, precision: 2, min: 0, max: 1, step: 0.1, modelValue: a.value.transparency, "onUpdate:modelValue": e[2] || (e[2] = (t) => a.value.transparency = t) }, null, 8, ["modelValue"]), e[9] || (e[9] = d("span", null, "(取值范围：0~1)", -1))]), _: 1, __: [9] }), l(n, { label: "水印-字体角度", prop: "angle" }, { default: o(() => [l(v, { class: "input-underline", controls: false, style: { width: "150px" }, min: -360, max: 360, step: 10, modelValue: a.value.angle, "onUpdate:modelValue": e[3] || (e[3] = (t) => a.value.angle = t) }, null, 8, ["modelValue"]), e[10] || (e[10] = d("span", null, "(取值范围：-360°~360°)", -1))]), _: 1, __: [10] }), l(n, { label: "水印-间隔", prop: "spacing" }, { default: o(() => [l(v, { class: "input-underline", style: { width: "178px" }, precision: 2, controls: false, modelValue: a.value.spacing, "onUpdate:modelValue": e[4] || (e[4] = (t) => a.value.spacing = t) }, null, 8, ["modelValue"]), e[11] || (e[11] = d("span", null, "mm", -1))]), _: 1, __: [11] })], 64)) : y("", true)]), _: 1 }, 8, ["model"])])), [[R, k.value || c.value]])]), _: 1 })) : y("", true);
  };
} }, ne = H(ae, [["__scopeId", "data-v-56bb66aa"]]);
export {
  ne as default
};
