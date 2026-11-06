import { ref as r } from "vue";
import { inject as C } from "vue";
import { reactive as F } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as T } from "vue";
import { createElementBlock as A } from "vue";
import { createVNode as t } from "vue";
import { withCtx as o } from "vue";
import { createTextVNode as _ } from "vue";
import { withDirectives as M } from "vue";
import { createBlock as P } from "vue";
import { unref as i } from "vue";
import { createElementVNode as Q } from "vue";
import { toDisplayString as $ } from "vue";
import { isRef as G } from "vue";
import { Fragment as H } from "vue";
import { ElTag as J } from "element-plus";
import { ElInput as K } from "element-plus";
import { ElFormItem as O } from "element-plus";
import { InfoFilled as W } from "@element-plus/icons-vue";
import { ElIcon as X } from "element-plus";
import { ElTooltip as Y } from "element-plus";
import { ElForm as Z } from "element-plus";
import { vLoading as ee } from "element-plus";
import { u as te, nr as ne, ca as oe, no as le } from "../../../../../../shared/runtime.js";
import { e as se } from "../../../../../../modules/nesting-setting-83aca0bd.js";
import ie from "./nesting-progress.vue.js";
const de = { __name: "extrusion-nesting-setting", props: { visible: { type: Boolean, default: false }, projectId: { type: [String, Number], default: void 0 }, detailData: { type: Array, default: () => [] }, monomerId: { type: Number } }, emits: ["update:visible"], setup(k, { emit: I }) {
  const y = r(), V = r(), b = C("crud"), d = r(false), p = r(false), v = r(), a = k, L = I, { visible: f, handleClose: E } = te({ emit: L, props: a, field: "visible" }), l = F({ kerfLength: 20, length: 12e3, typesettingTypeEnum: void 0 }), h = { kerfLength: [{ required: true, message: "请输入预留割缝", trigger: "blur" }], length: [{ required: true, message: "请输入母材长度", trigger: "blur" }], typesettingTypeEnum: [{ required: true, message: "请选择套料方式", trigger: "blur" }] };
  async function x(N) {
    try {
      const e = [], u = [];
      a.detailData.map((s) => {
        e.push({ id: s.assembleDetailId, quantity: s.quantity }), u.push(s.productionLineTypeEnum);
      });
      const c = { assembleSettingList: e, projectId: a.projectId, monomerId: a.monomerId, length: l.length, kerfLength: l.kerfLength, productionLineTypeEnum: u[0], typesettingTypeEnum: l.typesettingTypeEnum };
      v.value = await se(c), E(), d.value = true, setTimeout(() => {
        d.value = false;
      }, 2e3), b.toQuery(), p.value = true;
    } catch {
      console.log("套料失败");
    }
  }
  return (N, e) => {
    const u = J, c = g("common-button"), s = K, m = O, S = W, R = X, w = Y, B = g("common-radio"), D = Z, q = g("common-dialog"), U = ee, j = z("permission");
    return T(), A(H, null, [t(q, { ref_key: "dialogRef", ref: V, title: "套料设定", visible: i(f), "onUpdate:visible": e[4] || (e[4] = (n) => G(f) ? f.value = n : null), "before-close": i(E), width: "400px" }, { titleLeft: o(() => [t(u, null, { default: o(() => e[6] || (e[6] = [_("单位：mm")])), _: 1, __: [6] })]), titleRight: o(() => [M((T(), P(c, { type: "success", size: "default", onClick: e[0] || (e[0] = (n) => x(y.value)) }, { default: o(() => e[7] || (e[7] = [_(" 开始套料 ")])), _: 1, __: [7] })), [[U, d.value, void 0, { fullscreen: true, lock: true }], [j, i(ne).extrusionNesting]])]), default: o(() => [t(D, { ref_key: "formRef", ref: y, model: l, rules: h, size: "default", "label-width": "120px", class: "demo-form" }, { default: o(() => [t(m, { label: "预留割缝≤：", prop: "kerfLength" }, { default: o(() => [t(s, { modelValue: l.kerfLength, "onUpdate:modelValue": e[1] || (e[1] = (n) => l.kerfLength = n), style: { width: "200px" }, placeholder: "输入长度 单位：mm" }, null, 8, ["modelValue"])]), _: 1 }), t(m, { label: "母材长度≤：", prop: "length" }, { default: o(() => [t(s, { modelValue: l.length, "onUpdate:modelValue": e[2] || (e[2] = (n) => l.length = n), style: { width: "200px" }, placeholder: "输入长度 单位：mm" }, null, 8, ["modelValue"])]), _: 1 }), t(m, { label: "材料属性：", prop: "typesettingAssembleTypeEnum" }, { default: o(() => {
      var n;
      return [Q("span", null, $(i(oe).VL[(n = a.detailData[0]) == null ? void 0 : n.typesettingAssembleTypeEnum]), 1)];
    }), _: 1 }), t(m, { label: "套料方式", prop: "typesettingTypeEnum" }, { label: o(() => [e[8] || (e[8] = _(" 套料方式 ")), t(w, { effect: "dark", content: `如焊接型部件，可选择无损套料，选择无损套料将会按照约定的长度内进行套料

              如型材部件，可选择无损套料，选择有损套料，可能会产生一定的材料损耗`, placement: "bottom" }, { default: o(() => [t(R, null, { default: o(() => [t(S)]), _: 1 })]), _: 1 })]), default: o(() => [t(B, { class: "filter-item", modelValue: l.typesettingTypeEnum, "onUpdate:modelValue": e[3] || (e[3] = (n) => l.typesettingTypeEnum = n), options: i(le).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["visible", "before-close"]), t(ie, { visible: p.value, "onUpdate:visible": e[5] || (e[5] = (n) => p.value = n), batchId: v.value, onSuccess: i(b).toQuery }, null, 8, ["visible", "batchId", "onSuccess"])], 64);
  };
} };
export {
  de as default
};
