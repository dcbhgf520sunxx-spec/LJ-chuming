import { ref as f } from "vue";
import { computed as L } from "vue";
import { watch as S } from "vue";
import { useStore as O } from "vuex";
import { resolveComponent as c } from "vue";
import { openBlock as m } from "vue";
import { createBlock as p } from "vue";
import { withCtx as n } from "vue";
import { createVNode as t } from "vue";
import { withDirectives as j } from "vue";
import { createTextVNode as D } from "vue";
import { unref as i } from "vue";
import { isRef as K } from "vue";
import { ElNotification as P } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElInput as A } from "element-plus";
import { vLoading as F } from "element-plus";
import { hW as G, u as J, o as Q, hV as g, aV as X, aw as Z, i as ee, hY as ae } from "../../../../../shared/runtime.js";
const te = { __name: "workshop-form", props: { modelValue: { type: Boolean, require: true } }, emits: ["update:modelValue", "success"], setup(y, { emit: b }) {
  const V = b, { workshopName: k } = G(), x = y, { visible: u, handleClose: w } = J({ emit: V, props: x }), h = f(false), v = L(() => {
    const o = [];
    return k.value.forEach((e) => {
      e.workshopId && o.push(e.id);
    }), l.value.forEach((e) => {
      e.workshopId && o.push(e.workshopId);
    }), o;
  });
  S(u, (o) => {
    l.value = [];
  });
  const I = { name: [{ required: true, message: "请输入或选择车间", trigger: ["blur", "change"] }], type: [{ required: true, message: "请选择类型", trigger: "change" }] }, C = O(), l = f([]), _ = f(), { maxHeight: N } = Q({ mainBox: ".workshop-form", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, _), { tableValidate: R, wrongCellMask: U } = Z({ rules: I });
  function B(o) {
    ee(o) && (l.value[o.choseIndex].name = o.name);
  }
  function E() {
    l.value.push({ type: void 0, name: void 0 });
  }
  async function H(o) {
    const { validResult: e, dealList: d } = R(l.value);
    if (e) l.value = d;
    else return e;
    h.value = true;
    try {
      await ae(l.value), P({ title: "新增成功", type: "success" }), C.dispatch("config/fetchWorkshopName"), w();
    } catch (s) {
      console.log("仓库名称", s);
    } finally {
      h.value = false;
    }
  }
  function z(o) {
    l.value.splice(o, 1);
  }
  return (o, e) => {
    const d = c("common-button"), s = Y, M = c("common-select"), W = A, q = c("common-table"), T = c("common-drawer"), $ = F;
    return m(), p(T, { ref_key: "drawerRef", ref: _, title: "仓库名称", "close-on-click-modal": false, modelValue: i(u), "onUpdate:modelValue": e[0] || (e[0] = (a) => K(u) ? u.value = a : null), direction: "rtl", "before-close": i(w), "custom-class": "workshop-form", size: "800px" }, { titleRight: n(() => [t(d, { icon: "el-icon-plus", type: "warning", onClick: E, size: "default" }), j((m(), p(d, { size: "default", type: "primary", onClick: H }, { default: n(() => e[1] || (e[1] = [D("提交")])), _: 1, __: [1] })), [[$, h.value]])]), content: n(() => [t(q, { data: l.value, "cell-class-name": i(U), "max-height": i(N), "return-source-data": "", "show-empty-symbol": false }, { default: n(() => [t(s, { label: "序号", type: "index", align: "center", width: "60" }), t(s, { key: "type", prop: "type", label: "类型", align: "center" }, { default: n((a) => [t(M, { modelValue: a.row.type, "onUpdate:modelValue": (r) => a.row.type = r, options: i(g).ENUM, type: "enum", placeholder: "类型", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 1 }), t(s, { key: "name", prop: "name", label: "仓库名称", align: "center" }, { default: n((a) => [a.row.type === i(g).WORKSHOP.V ? (m(), p(X, { key: 0, modelValue: a.row.workshopId, "onUpdate:modelValue": (r) => a.row.workshopId = r, placeholder: "请选择", choseIndex: a.$index, disabledVal: v.value, onNameChange: B, style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "choseIndex", "disabledVal"])) : (m(), p(W, { key: 1, modelValue: a.row.name, "onUpdate:modelValue": (r) => a.row.name = r, modelModifiers: { trim: true }, type: "text", clearable: "", placeholder: "名称", size: "default", style: { width: "100%" }, maxlength: "20" }, null, 8, ["modelValue", "onUpdate:modelValue"]))]), _: 1 }), t(s, { label: "操作", width: "130px", align: "center", fixed: "right" }, { default: n((a) => [t(d, { icon: "el-icon-delete", type: "danger", size: "default", onClick: (r) => z(a.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  te as default
};
