import { useStore as P } from "vuex";
import { computed as w } from "vue";
import { watch as T } from "vue";
import { ref as M } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as U } from "vue";
import { createBlock as E } from "vue";
import { mergeProps as F } from "vue";
import { unref as h } from "vue";
import { withCtx as g } from "vue";
import { createVNode as s } from "vue";
import { createTextVNode as G } from "vue";
import { withModifiers as L } from "vue";
import { isRef as J } from "vue";
import { ElMessage as Q } from "element-plus";
import { ElNotification as B } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { ElInput as X } from "element-plus";
import { ElInputNumber as Y } from "element-plus";
import { b as R, ai as Z, u as ee, o as le, aw as ae, V as te, aI as oe, sG as se, c9 as ne } from "../../../../../../../shared/runtime.js";
import { u as ie } from "../../../../../../../modules/use-table-operate-4f84437f.js";
const S = (o, _ = false) => {
  const n = P(), p = w(() => n.state.config.loaded.steelClassifyConf);
  if ((!p.value || _) && (n.commit("config/SET_LOADED", { key: "steelClassifyConf", loaded: false }), n.dispatch("config/fetchSteelClassifyConf")), o) {
    const u = T(p, (b) => {
      b && setTimeout(() => {
        o(n.state.config.steelClassifyConfICKV), u();
      }, 0);
    }, { immediate: true });
  }
  return { loaded: p, steelClassifyConf: w(() => n.state.config.steelClassifyConf), steelClassifyConfKV: w(() => n.state.config.steelClassifyConfKV), steelClassifyConfICKV: w(() => n.state.config.steelClassifyConfICKV) };
}, ue = { __name: "part-steel-classify-type-select", props: { modelValue: { type: [Number, String], default: void 0 }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false }, placeholder: { type: String, default: "钢材种类" }, onlyOneDefault: { type: Boolean, default: true } }, emits: ["change", "update:modelValue"], setup(o, { emit: _ }) {
  const n = _, p = o, u = M(), { loaded: b, steelClassifyConf: x } = S();
  T(() => p.modelValue, (V) => {
    u.value = V;
  }, { immediate: true });
  function k(V) {
    let d = V;
    R(d) && (d = void 0);
    const v = !Z(d, p.modelValue), C = R(d) && R(p.modelValue);
    v && !C && (n("update:modelValue", d), n("change", d));
  }
  return (V, d) => {
    const v = I("common-select");
    return U(), E(v, F(V.$attrs, { modelValue: u.value, "onUpdate:modelValue": d[0] || (d[0] = (C) => u.value = C), size: o.size, disabled: o.disabled, multiple: o.multiple, "collapse-tags": o.collapseTags, loading: !h(b), clearable: o.clearable, showOptionAll: o.showOptionAll, allLabelText: "钢材种类", filterable: "", placeholder: o.placeholder, options: h(x), "only-one-default": o.onlyOneDefault, onChange: k }), null, 16, ["modelValue", "size", "disabled", "multiple", "collapse-tags", "loading", "clearable", "showOptionAll", "placeholder", "options", "only-one-default"]);
  };
} }, fe = { __name: "tech-add-form", props: { modelValue: { type: Boolean, default: false }, technologyList: { type: Array, default: () => [] } }, emits: ["update:modelValue", "success"], setup(o, { emit: _ }) {
  const n = _, p = o, u = M([]), b = M(false), x = /* @__PURE__ */ new Map([["steelClassifyConfId", -1]]), k = { steelClassifyConfId: void 0, material: void 0, specification: void 0, listMete: void 0 }, { init: V, addRow: d, removeRow: v } = ie(k, 10, x), { visible: C, handleClose: $ } = ee({ emit: n, props: p, showHook: () => {
    V(u.value);
  } }), O = { steelClassifyConfId: [{ required: true, message: "请选择钢材种类", trigger: "change" }], material: [{ required: true, max: 20, message: "请填写材质", trigger: "blur" }], specification: [{ required: true, max: 60, message: "请填写厚度/规格", trigger: "blur" }], listMete: [{ required: true, max: 60, message: "请填写清单量", trigger: "blur" }, { pattern: ne, message: "清单量必须大于0", trigger: "blur" }] }, { tableValidate: A, cleanUpData: N, wrongCellMask: z } = ae({ rules: O, ditto: x }), { steelClassifyConfKV: j } = S(), { maxHeight: D } = le({ mainBox: ".plan-material-preparation-project-form", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, extraHeight: "10vh", navbar: false }, C);
  async function H() {
    try {
      b.value = true;
      const { validResult: r, dealList: f } = A(u.value);
      if (u.value = f, !r) return false;
      const c = N(te(f));
      if (c.forEach((e) => {
        const l = j.value[e.steelClassifyConfId];
        e.id = oe(), e.operateType = se.ADD.V, e.steelClassifyConfName = l.name, e.basicClass = l.basicClass, e.boundInvIds = [], e.boundPurIds = [];
      }), !K(c, p.technologyList)) return false;
      n("success", c), Q.success("添加成功"), $();
    } catch (r) {
      console.log("科目添加", r);
    } finally {
      b.value = false;
    }
  }
  function K(r = [], f = []) {
    let c = /* @__PURE__ */ new Map(), t = [];
    for (let e = 0; e < r.length; e++) if (!c.get(e)) {
      const l = r[e], i = [e + 1];
      for (let m = e + 1; m < r.length; m++) {
        const a = r[m];
        l.steelClassifyConfId === a.steelClassifyConfId && l.material === a.material && l.specification === a.specification && (c.set(m, true), i.push(m + 1));
      }
      i.length > 1 && t.push({ info: l, index: i });
    }
    if (t.length > 0) {
      let e = "";
      return t.forEach((l, i) => {
        e += `${i + 1}.${l.info.steelClassifyConfName}-${l.info.material}-${l.info.specification}: 第${l.index.join("、")}行
`;
      }), B.warning({ title: "添加清单数据重复", message: e, duration: 6e4 }), false;
    }
    c = /* @__PURE__ */ new Map(), t = [];
    for (let e = 0; e < r.length; e++) {
      const l = r[e];
      for (let i = 0; i < f.length; i++) {
        const m = f[i];
        if (l.steelClassifyConfId === m.steelClassifyConfId && l.material === m.material && l.specification === m.specification) {
          t.push({ info: l, index: e + 1 });
          break;
        }
      }
    }
    if (t.length > 0) {
      let e = "";
      return t.forEach((l, i) => {
        e += `${i + 1}.${l.info.steelClassifyConfName}-${l.info.material}-${l.info.specification}: 第${l.index}行
`;
      }), B.warning({ title: "添加清单与现有清单数据重复", message: e, duration: 6e4 }), false;
    }
    return true;
  }
  return (r, f) => {
    const c = I("common-button"), t = W, e = X, l = Y, i = I("common-table"), m = I("common-dialog");
    return U(), E(m, { title: "添加备料清单", modelValue: h(C), "onUpdate:modelValue": f[1] || (f[1] = (a) => J(C) ? C.value = a : null), width: "850px", "show-close": "", "before-close": h($), "custom-class": "plan-material-preparation-project-form", top: "10vh" }, { titleRight: g(() => [s(c, { size: "default", type: "success", icon: "el-icon-plus", onClick: f[0] || (f[0] = (a) => h(d)(u.value)) }), s(c, { loading: b.value, type: "primary", size: "default", onClick: H }, { default: g(() => f[2] || (f[2] = [G("保 存")])), _: 1, __: [2] }, 8, ["loading"])]), default: g(() => [s(i, { data: u.value, "show-empty-symbol": false, "return-source-data": "", "cell-class-name": h(z), "max-height": h(D), "row-key": "uid" }, { default: g(() => [s(t, { label: "序号", type: "index", align: "center", width: "60" }), s(t, { label: "钢材种类", key: "steelClassifyConfId", prop: "steelClassifyConfId", align: "center", width: "150" }, { default: g(({ row: a, $index: y }) => [s(ue, { modelValue: a.steelClassifyConfId, "onUpdate:modelValue": (q) => a.steelClassifyConfId = q, "show-extra": y !== 0 }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 }), s(t, { label: "材质", key: "material", prop: "material", align: "center", width: "120" }, { default: g(({ row: a }) => [s(e, { modelValue: a.material, "onUpdate:modelValue": (y) => a.material = y, placeholder: "材质" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(t, { label: "厚度/规格", key: "specification", prop: "specification", align: "center", "min-width": "120" }, { default: g(({ row: a }) => [s(e, { modelValue: a.specification, "onUpdate:modelValue": (y) => a.specification = y, placeholder: "厚度/规格" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(t, { label: "清单量(kg)", key: "listMete", prop: "listMete", align: "center", width: "150" }, { default: g(({ row: a }) => [s(l, { modelValue: a.listMete, "onUpdate:modelValue": (y) => a.listMete = y, controls: false, max: 999999999, placeholder: "清单量" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(t, { label: "操作", align: "center", width: "70" }, { default: g(({ $index: a }) => [s(c, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, onClick: L((y) => h(v)(u.value, a), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, me = Object.freeze(Object.defineProperty({ __proto__: null, default: fe }, Symbol.toStringTag, { value: "Module" }));
export {
  fe as _,
  me as t,
  S as u
};
