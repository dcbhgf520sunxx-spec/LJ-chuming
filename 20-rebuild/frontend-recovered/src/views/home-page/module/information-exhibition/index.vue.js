import { ref as i } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as l } from "vue";
import { createElementVNode as h } from "vue";
import { unref as d } from "vue";
import { createBlock as r } from "vue";
import { withCtx as m } from "vue";
import { createTextVNode as k } from "vue";
import { createCommentVNode as C } from "vue";
import { Fragment as V } from "vue";
import { renderList as E } from "vue";
import { createVNode as f } from "vue";
import { ElImage as L } from "element-plus";
import { ElCarouselItem as I } from "element-plus";
import { ElCarousel as w } from "element-plus";
import { g as B, _ as N } from "./add-dialog.vue.js";
import { c as $ } from "../../../../modules/home-page-66a3681d.js";
import { _ as D, G as M } from "../../../../shared/runtime.js";
import "../../../../modules/PicUpload-8580ccfc.js";
const P = { class: "information-main" }, S = { key: 2, class: "no-exhibition" }, T = { __name: "index", setup(U) {
  const n = i(false), a = i(false), s = i([]);
  u();
  async function u() {
    const { attachmentDTOList: c } = await B();
    s.value = c || [];
  }
  return (c, e) => {
    var _;
    const p = y("common-button"), v = L, g = I, x = w;
    return o(), l("div", P, [h("div", { class: "firm-exhibition", onMouseenter: e[1] || (e[1] = (t) => n.value = true), onMouseleave: e[2] || (e[2] = (t) => n.value = false) }, [n.value && d(M)(d($).editExhibition) ? (o(), r(p, { key: 0, class: "create-btn", type: "primary", size: "mini", onClick: e[0] || (e[0] = (t) => a.value = true) }, { default: m(() => e[4] || (e[4] = [k("编辑")])), _: 1, __: [4] })) : C("", true), (_ = s.value) != null && _.length ? (o(), r(x, { key: 1, style: { height: "100%" }, height: "100%" }, { default: m(() => [(o(true), l(V, null, E(s.value, (t, b) => (o(), r(g, { key: b }, { default: m(() => [f(v, { style: { width: "100%", height: "100%" }, src: t.imageUrl, fit: "cover" }, null, 8, ["src"])]), _: 2 }, 1024))), 128))]), _: 1 })) : (o(), l("div", S, "暂未配置展示图片"))], 32), f(N, { modelValue: a.value, "onUpdate:modelValue": e[3] || (e[3] = (t) => a.value = t), onAddSuccess: u, imgList: s.value }, null, 8, ["modelValue", "imgList"])]);
  };
} }, H = D(T, [["__scopeId", "data-v-9883137e"]]);
export {
  H as default
};
