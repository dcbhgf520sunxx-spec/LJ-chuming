import { computed as j } from "vue";
import { ref as n } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as s } from "vue";
import { createBlock as b } from "vue";
import { withCtx as i } from "vue";
import { createVNode as c } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as V } from "vue";
import { unref as _ } from "vue";
import { createElementBlock as E } from "vue";
import { Fragment as q } from "vue";
import { createCommentVNode as le } from "vue";
import { createElementVNode as oe } from "vue";
import { withDirectives as ne } from "vue";
import { normalizeClass as F } from "vue";
import { isRef as ie } from "vue";
import { ElMessage as re } from "element-plus";
import { ElTag as se } from "element-plus";
import { ElTableColumn as ce } from "element-plus";
import { ElInputNumber as de } from "element-plus";
import { vLoading as ue } from "element-plus";
import { l as B, _ as me, u as pe, o as ge, V as O, G as fe, nB as ve, aw as _e } from "../../../../../shared/runtime.js";
function ye(m) {
  return B({ module: "plan", url: "CappCraftProductPassTaskRecord/welding/gather/list", method: "get", params: m });
}
function z(m) {
  return B({ module: "plan", url: "CappCraftProductPassTaskRecord/welding/gather/detail", method: "get", params: m });
}
function A(m) {
  return B({ module: "plan", url: "CappCraftProductPassTaskRecord/welding/gather/update", method: "post", data: m });
}
const Re = { get: ye, detail: z, save: A };
const be = { class: "query-wrap" }, he = { __name: "form", props: { modelValue: { type: Boolean, default: false }, detailRow: { type: Object, default: () => ({}) } }, emits: ["update:modelValue", "success"], setup(m, { emit: L }) {
  const D = L, l = m, { visible: T, handleClose: W } = pe({ emit: D, props: l, showHook: Z }), $ = j(() => [l.detailRow.productSerialNumber, l.detailRow.weldingSerialNumber, l.detailRow.weldingCraftParameterPass].join(" > ")), S = j(() => g.value.filter((o, e) => {
    const r = p.value[e];
    return o.electricity !== r.electricity || o.voltage !== r.voltage;
  })), H = n(9999), N = n(false), w = n(false), p = n([]), I = n(), g = n([]), d = n(false), P = n(-1), x = n(P.value), G = n([["createTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), J = n([{ name: "全部", id: P.value }, { name: "只看额定范围外", id: false }, { name: "只看额定范围内", id: true }]), K = { electricity: [{ required: true, message: "请填写电流", trigger: "blur" }], voltage: [{ required: true, message: "请填写电压", trigger: "blur" }] }, { tableValidate: Q, wrongCellMask: X } = _e({ rules: K }), { maxHeight: Y } = ge({ mainBox: ".capp-welding-record-detail", extraBox: [".el-dialog__header", ".query-wrap"], wrapperBox: [".el-dialog__body"], minHeight: 200, clientHRepMainH: true }, I);
  function Z() {
    M();
  }
  function M() {
    d.value = false, g.value = [], U();
  }
  async function U() {
    var o, e;
    try {
      N.value = true, p.value = [];
      const r = { passId: l.detailRow.passId, ratedElectricity: l.detailRow.ratedElectricity, ratedVoltage: l.detailRow.ratedVoltage };
      x.value !== P.value && (r.isWithinTheRatedRange = x.value), p.value = await z(r);
      let f, R, t = (((o = l.detailRow) == null ? void 0 : o.ratedElectricity) || "").split("~");
      t.length === 2 && (f = Number(t[0]), R = Number(t[1]));
      let y, k;
      t = (((e = l.detailRow) == null ? void 0 : e.ratedVoltage) || "").split("~"), t.length === 2 && (y = Number(t[0]), k = Number(t[1])), p.value.forEach((u) => {
        u.abnormalElectricity = u.electricity < f || u.electricity > R, u.abnormalVoltage = u.voltage < y || u.voltage > k;
      });
    } catch (r) {
      console.log("获取焊接数据详情失败", r);
    } finally {
      N.value = false, g.value = O(p.value);
    }
  }
  function ee() {
    d.value = false, g.value = O(p.value);
  }
  async function ae() {
    try {
      w.value = true;
      const { validResult: o } = Q(g.value);
      o && (await A(S.value), re.success("提交成功"), D("success"), M());
    } catch (o) {
      console.log("保存焊接数据失败", o);
    } finally {
      w.value = false;
    }
  }
  return (o, e) => {
    const r = se, f = C("common-button"), R = C("common-radio-button"), t = ce, y = de, k = C("common-table"), u = C("common-dialog"), te = ue;
    return s(), b(u, { customClass: "capp-welding-record-detail", title: "焊接数据详情", modelValue: _(T), "onUpdate:modelValue": e[2] || (e[2] = (a) => ie(T) ? T.value = a : null), direction: "rtl", "before-close": _(W), width: "700px", top: "50px" }, { titleAfter: i(() => [c(r, { effect: "plain" }, { default: i(() => [h(V($.value), 1)]), _: 1 })]), titleRight: i(() => [_(fe)(_(ve).edit) ? (s(), E(q, { key: 0 }, [d.value ? (s(), E(q, { key: 0 }, [c(f, { loading: w.value, disabled: !S.value.length, type: "primary", onClick: ae }, { default: i(() => e[3] || (e[3] = [h("保存")])), _: 1, __: [3] }, 8, ["loading", "disabled"]), c(f, { loading: w.value, onClick: ee }, { default: i(() => e[4] || (e[4] = [h("取消")])), _: 1, __: [4] }, 8, ["loading"])], 64)) : (s(), b(f, { key: 1, type: "primary", onClick: e[0] || (e[0] = (a) => d.value = true) }, { default: i(() => e[5] || (e[5] = [h("编辑")])), _: 1, __: [5] }))], 64)) : le("", true)]), default: i(() => [oe("div", be, [c(R, { modelValue: x.value, "onUpdate:modelValue": e[1] || (e[1] = (a) => x.value = a), options: J.value, onChange: U }, null, 8, ["modelValue", "options"]), c(r, { effect: "plain", size: "large" }, { default: i(() => {
      var a, v;
      return [h(" 额定电流：" + V((a = l.detailRow) == null ? void 0 : a.ratedElectricity) + "   额定电压：" + V((v = l.detailRow) == null ? void 0 : v.ratedVoltage), 1)];
    }), _: 1 })]), ne((s(), b(k, { ref_key: "tableRef", ref: I, returnSourceData: "", data: g.value, "max-height": _(Y), "data-format": G.value, "cell-class-name": _(X) }, { default: i(() => [c(t, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), c(t, { key: "createTime", prop: "createTime", label: "时间", align: "center", "min-width": "100px" }), c(t, { key: "electricity", prop: "electricity", label: `${d.value ? "*" : ""}电流(A)`, align: "center", "min-width": "100px" }, { default: i(({ row: a }) => [d.value ? (s(), b(y, { key: 0, modelValue: a.electricity, "onUpdate:modelValue": (v) => a.electricity = v, placeholder: "实际电流", min: 0, max: H.value, step: 1, precision: 2, controls: false, style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])) : (s(), E("span", { key: 1, class: F({ "tc-danger": a.abnormalElectricity }) }, V(a.electricity), 3))]), _: 1 }, 8, ["label"]), c(t, { key: "voltage", prop: "voltage", label: `${d.value ? "*" : ""}电压(V)`, align: "center", "min-width": "100px" }, { default: i(({ row: a }) => [d.value ? (s(), b(y, { key: 0, modelValue: a.voltage, "onUpdate:modelValue": (v) => a.voltage = v, placeholder: "实际电压", min: 0, max: H.value, step: 1, precision: 2, controls: false, style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])) : (s(), E("span", { key: 1, class: F({ "tc-danger": a.abnormalVoltage }) }, V(a.voltage), 3))]), _: 1 }, 8, ["label"])]), _: 1 }, 8, ["data", "max-height", "data-format", "cell-class-name"])), [[te, N.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ve = me(he, [["__scopeId", "data-v-8ed91235"]]), ke = Object.freeze(Object.defineProperty({ __proto__: null, default: Ve }, Symbol.toStringTag, { value: "Module" }));
export {
  Re as c,
  ke as f,
  Ve as m
};
