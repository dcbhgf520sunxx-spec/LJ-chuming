import { ref as u } from "vue";
import { reactive as te } from "vue";
import { provide as v } from "vue";
import { computed as O } from "vue";
import { watchEffect as se } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as q } from "vue";
import { createBlock as R } from "vue";
import { withCtx as f } from "vue";
import { createVNode as m } from "vue";
import { unref as _ } from "vue";
import { createTextVNode as A } from "vue";
import { createElementVNode as ne } from "vue";
import { resolveDynamicComponent as le } from "vue";
import { isRef as oe } from "vue";
import { ElMessage as ie } from "element-plus";
import { ElNotification as re } from "element-plus";
import { ElCard as de } from "element-plus";
import { c as ue } from "../../../../../modules/artifact-tree-bcd3b733.js";
import { _ as fe, u as ce, b as I } from "../../../../../shared/runtime.js";
import { d as n, b as x } from "../../../../../modules/common-ac6e385c.js";
import { c as me, u as pe } from "../../../../../modules/index-002b3f81.js";
import be from "./module/handle.vue.js";
import he from "./module/reason.vue.js";
import "../../../../../modules/assemble-change-set-01d99287.js";
import "../../../../../modules/machine-part-change-table-207fbedf.js";
const ve = { class: "step-btn" }, ge = { __name: "change-drawer", props: { visible: { type: Boolean, default: false }, originChangeInfo: { type: Object, default: () => {
} }, monomerId: { type: [Number, void 0], default: void 0 }, projectId: { type: [Number, void 0], default: void 0 } }, emits: ["update:visible"], setup(z, { emit: B }) {
  const M = u(), Q = B, c = z, { visible: N, handleClose: y } = ce({ emit: Q, props: c, field: "visible", showHook: G }), { handleAssembleList: U, handleCompareAssembleList: P, handleComparePartList: K } = pe(), p = u(), C = te([{ title: "变更处理" }, { title: "变更原因填写" }]), $ = [be, he], l = u(0), w = u(false), g = u({}), b = u([]), E = u(/* @__PURE__ */ new Map());
  v("form", g), v("changeInfo", b), v("changeInfoMap", E), v("originChangeInfo", c.originChangeInfo);
  const F = O(() => $[l.value]), V = O(() => {
    let a = 0;
    return b.value.forEach((e) => {
      e.artifactHandleStatus & (n.HANDLED.V | n.NOT_HANDLE.V | n.CANCEL_HANDLE.V) && a++;
    }), a;
  });
  v("handledQuantity", V);
  function G() {
    const a = [];
    for (let e = 0; e < c.originChangeInfo.length; e++) {
      const t = c.originChangeInfo[e];
      t.partCompareList = K(t.oldArtifact.partList || [], t.newArtifact.partList || []), t.assembleInfo = U(t.oldArtifact.assembleList || [], t.newArtifact.assembleList || []), t.artifactHandleStatus = J(t), t.boolTag = false, t.boolDel = false, t.foldOpened = true, W(t), a.push(t), E.value.set(t.newArtifact.serialNumber, t);
    }
    console.log({ _list: a }), b.value = a;
  }
  function W(a) {
    se(() => {
      const { assembleCompareList: e, isAssembleHandled: t } = P(a.assembleInfo);
      a.assembleCompareList = e, t ? a.artifactHandleStatus = n.HANDLED.V : a.artifactHandleStatus === n.HANDLED.V && (a.artifactHandleStatus = n.UN_HANDLE.V), a.boolDel && (a.artifactHandleStatus = n.CANCEL_HANDLE.V), a.boolTag && (a.artifactHandleStatus |= n.TAG.V);
    });
  }
  function J(a) {
    var t, i, r;
    let e;
    return I((t = a.assembleInfo) == null ? void 0 : t.needHandleOldList) && I((i = a.assembleInfo) == null ? void 0 : i.needHandleNewList) && I((r = a.assembleInfo) == null ? void 0 : r.amList) ? e = n.NOT_HANDLE.V : e = n.UN_HANDLE.V, e;
  }
  async function X() {
    var a;
    if (l.value === 0) {
      const e = b.value.length - V.value;
      if (e) {
        ie.warning(`变更构件还有${e}种未处理`);
        return;
      }
    }
    (a = p.value) != null && a.validate && !await p.value.validate() || l.value++;
  }
  async function Y() {
    var a, e, t, i, r, d, S, D, k;
    if (!((a = p.value) != null && a.validate && !await p.value.validate())) try {
      w.value = true;
      const h = [];
      for (const o of b.value) {
        if (o.artifactHandleStatus & n.CANCEL_HANDLE.V) continue;
        const L = [];
        for (const s of (e = o.assembleInfo) == null ? void 0 : e.needHandleNewList) {
          const T = [];
          for (const H of s.oldSerialNumbers) T.push({ assembleChangeTypeEnum: s.handleObj[H].handleType, oldAssembleSerialNumber: H, quantity: s.handleObj[H].quantity });
          L.push({ ...s, changeLinkList: T });
        }
        for (const s of (t = o.assembleInfo) == null ? void 0 : t.sameList) L.push({ ...s.newAssemble, changeLinkList: [{ assembleChangeTypeEnum: x.KEEP.V, oldAssembleSerialNumber: (i = s.oldAssemble) == null ? void 0 : i.serialNumber, quantity: (r = s.oldAssemble) == null ? void 0 : r.quantity }] });
        for (const s of (d = o.assembleInfo) == null ? void 0 : d.amList) L.push({ ...s.newAssemble, changeLinkList: [{ assembleChangeTypeEnum: x.KEEP.V, oldAssembleSerialNumber: (S = s.oldAssemble) == null ? void 0 : S.serialNumber, quantity: (D = s.oldAssemble) == null ? void 0 : D.quantity }] });
        const ae = { ...o.newArtifact, areaList: o.areaList.map((s) => ({ id: s.id, quantity: s.newQuantity })), assembleList: L };
        h.push(ae);
      }
      const Z = (k = g.value.attachments) != null && k.length ? g.value.attachments.map((o) => o.id) : void 0, ee = { ...g.value, monomerId: c.monomerId, projectId: c.projectId, newArtifactList: h, attachmentIds: Z };
      await ue(ee), re.success("提交成功"), y();
    } catch (h) {
      console.log(h);
    } finally {
      w.value = false;
    }
  }
  return (a, e) => {
    const t = j("common-button"), i = de, r = j("common-drawer");
    return q(), R(r, { ref_key: "drawerRef", ref: M, title: "清单变更", modelValue: _(N), "onUpdate:modelValue": e[2] || (e[2] = (d) => oe(N) ? N.value = d : null), direction: "rtl", showClose: false, "before-close": _(y), size: "100%" }, { titleRight: f(() => [m(t, { onClick: _(y), size: "default", plain: "" }, { default: f(() => e[3] || (e[3] = [A("取消本次变更")])), _: 1, __: [3] }, 8, ["onClick"])]), content: f(() => [m(i, { class: "step-content" }, { default: f(() => [m(_(me), { modelValue: l.value, "onUpdate:modelValue": e[0] || (e[0] = (d) => l.value = d), options: C, space: "33%", "finish-status": "success" }, null, 8, ["modelValue", "options"]), ne("span", ve, [m(t, { size: "default", plain: "", disabled: l.value === 0, onClick: e[1] || (e[1] = (d) => l.value--) }, { default: f(() => e[4] || (e[4] = [A("上一步")])), _: 1, __: [4] }, 8, ["disabled"]), m(t, { size: "default", plain: "", disabled: l.value === C.length - 1, onClick: X }, { default: f(() => e[5] || (e[5] = [A("下一步")])), _: 1, __: [5] }, 8, ["disabled"]), m(t, { loading: w.value, size: "default", type: "warning", disabled: l.value !== C.length - 1, onClick: Y }, { default: f(() => e[6] || (e[6] = [A(" 确认提交 ")])), _: 1, __: [6] }, 8, ["loading", "disabled"])])]), _: 1 }), (q(), R(le(F.value), { ref_key: "componentRef", ref: p, "height-style": a.heightStyle }, null, 8, ["height-style"]))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ee = fe(ge, [["__scopeId", "data-v-2cebeb1b"]]);
export {
  Ee as default
};
