import { ref as c } from "vue";
import { watch as L } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as B } from "vue";
import { createBlock as N } from "vue";
import { withCtx as a } from "vue";
import { createVNode as s } from "vue";
import { createTextVNode as v } from "vue";
import { unref as i } from "vue";
import { createElementVNode as y } from "vue";
import { isRef as R } from "vue";
import { ElNotification as z } from "element-plus";
import { ElFormItem as E } from "element-plus";
import { ElForm as j } from "element-plus";
import { l as b, u as F, S as M } from "../../../../shared/runtime.js";
import { _ as O } from "../../../../modules/PicUpload-8580ccfc.js";
function q(o) {
  return b({ url: "/api/img/lists", method: "get", params: o });
}
function P(o) {
  return b({ url: "/api/img/import", method: "post", data: o });
}
const S = { style: { "padding-left": "110px" } }, A = { __name: "add-dialog", props: { modelValue: { type: Boolean, default: false }, imgList: { type: Array, default: () => [] } }, emits: ["update:modelValue", "add-success"], setup(o, { emit: I }) {
  const f = o, p = I, { visible: n, handleClose: r } = F({ emit: p, props: f, showHook: w }), m = c(), t = c({}), d = c(false), h = { attachmentIds: [{ required: true, message: "请导入图片", trigger: "change" }] };
  L(() => {
    var l;
    return (l = t.value) == null ? void 0 : l.attachmentIds;
  }, (l) => {
    var e;
    (e = m.value) == null || e.validateField("attachmentIds");
  }, { deep: true });
  function w() {
    t.value.attachmentIds = f.imgList || [];
  }
  async function V() {
    if (await m.value.validate()) try {
      d.value = true, await P(t.value), r(), z({ title: "插图图片设置成功", type: "success", duration: 2500 }), p("add-success"), t.value = {};
    } catch (e) {
      console.log(e);
    } finally {
      d.value = false;
    }
  }
  return (l, e) => {
    const _ = g("common-button"), k = E, C = j, x = g("common-dialog");
    return B(), N(x, { modelValue: i(n), "onUpdate:modelValue": e[1] || (e[1] = (u) => R(n) ? n.value = u : null), "before-close": i(r), title: "插图图片", width: "685px", showClose: false, "close-on-click-modal": false, "destroy-on-close": "" }, { titleRight: a(() => [s(_, { type: "primary", size: "mini", onClick: V, Loading: d.value }, { default: a(() => e[2] || (e[2] = [v("保存")])), _: 1, __: [2] }, 8, ["Loading"]), s(_, { onClick: i(r), size: "mini", plain: "" }, { default: a(() => e[3] || (e[3] = [v("取消")])), _: 1, __: [3] }, 8, ["onClick"])]), default: a(() => [s(C, { ref_key: "formRef", ref: m, "label-width": "110px", model: t.value, rules: h }, { default: a(() => [s(k, { label: "图片导入：", prop: "attachmentIds" }, { default: a(() => e[4] || (e[4] = [y("span", { style: { color: "#ababab" } }, "仅限导入3张图片,仅支持PNG或JPG格式，尺寸：1090 × 390", -1)])), _: 1, __: [4] }), y("div", S, [s(i(O), { files: t.value.attachmentIds, "onUpdate:files": e[0] || (e[0] = (u) => t.value.attachmentIds = u), "file-classify": i(M).NORMAL.V, limit: 3, showMoveBtn: "" }, null, 8, ["files", "file-classify"])])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, D = Object.freeze(Object.defineProperty({ __proto__: null, default: A }, Symbol.toStringTag, { value: "Module" }));
export {
  A as _,
  D as a,
  q as g
};
