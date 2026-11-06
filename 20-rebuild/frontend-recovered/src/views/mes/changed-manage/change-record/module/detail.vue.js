import { ref as b } from "vue";
import { provide as q } from "vue";
import { computed as z } from "vue";
import { watch as ae } from "vue";
import { resolveComponent as H } from "vue";
import { openBlock as R } from "vue";
import { createBlock as B } from "vue";
import { withCtx as v } from "vue";
import { createVNode as w } from "vue";
import { createTextVNode as Q } from "vue";
import { toDisplayString as M } from "vue";
import { createElementVNode as U } from "vue";
import { unref as P } from "vue";
import { normalizeStyle as se } from "vue";
import { withDirectives as ne } from "vue";
import { resolveDynamicComponent as ie } from "vue";
import { isRef as oe } from "vue";
import { ElMessage as le } from "element-plus";
import { ElNotification as re } from "element-plus";
import { ElTag as ce } from "element-plus";
import { ElCard as ue } from "element-plus";
import { vLoading as me } from "element-plus";
import { l as N, V as T, iX as fe, a9 as j, a$ as E, _ as de, u as pe, aI as ge, D as he, i as ye } from "../../../../../shared/runtime.js";
import { c as F } from "../../../../../modules/common-ac6e385c.js";
import { c as be, u as _e } from "../../../../../modules/index-002b3f81.js";
import Le from "./change-detail/reason.vue.js";
import ve from "./change-detail/handle-info.vue.js";
import ke from "./change-detail/assemble-rescheduling.vue.js";
import we from "./change-detail/assemble-point-work-scheduling.vue.js";
function Se(n) {
  return N({ module: "mes", url: "tech/change/page", method: "get", params: n });
}
function Te(n) {
  return N({ module: "mes", url: `tech/change/${n}`, method: "get" });
}
function We(n) {
  return N({ module: "mes", url: `tech/change/${n}/task/issued/temporary`, method: "get" });
}
function Ae(n) {
  return N({ module: "mes", url: "tech/change/task/handle/temporary", method: "put", data: n });
}
const ze = { get: Se };
function Ce() {
  const n = b({});
  return q("summaryInfo", n), { handleSummaryData: (_) => {
    var A, I;
    const y = {}, c = {}, f = {};
    for (const d of _) {
      const u = T(d.oldArtifact), s = T(d.newArtifact), h = `${u.serialNumber}_${u.specification}_${u.length}_${u.netWeight}__${s.serialNumber}_${s.specification}_${s.length}_${s.netWeight}`, k = u.quantity - s.quantity || 0, V = fe(u.totalNetWeight - s.totalNetWeight || 0, 2);
      if (y[h] ? (y[h].oldArtifact.quantity += u.quantity, y[h].newArtifact.quantity += s.quantity, y[h].diffQuantity += k, y[h].diffTotalWeight += V, x(y[h].processSummary, u.processSummaryList)) : y[h] = { oldArtifact: u, newArtifact: s, processSummary: j(u.processSummaryList || [], "name"), diffLength: u.length - s.length || 0, diffQuantity: k, diffTotalWeight: V }, (A = d == null ? void 0 : d.assembleCompareList) != null && A.length) for (const t of d.assembleCompareList) {
        const i = t.oldAssemble ? T(t.oldAssemble) : {}, p = t.newAssemble ? T(t.newAssemble) : {}, g = `${i.serialNumber}_${i.specification}_${i.length}_${i.netWeight}__${p.serialNumber}_${p.specification}_${p.length}_${p.netWeight}`;
        c[g] ? (c[g].oldAssemble.quantity += i.quantity, c[g].newAssemble.quantity += p.quantity, c[g].diffQuantity += t.diffQuantity, c[g].diffTotalWeight += t.diffTotalWeight, x(c[g].processSummary, i.processSummaryList)) : c[g] = { ...T(t), processSummary: j(i.processSummaryList || [], "name") };
      }
      if ((I = d == null ? void 0 : d.partCompareList) != null && I.length) for (const t of d.partCompareList) {
        const i = `${t.serialNumber}_${t.specification}_${t.length}_${t.netWeight}_${t.changeType}`;
        f[i] ? (f[i].oldQuantity += t.oldQuantity, f[i].newQuantity += t.newQuantity, f[i].diffQuantity += t.diffQuantity, f[i].diffTotalWeight += t.diffTotalWeight, x(f[i].processSummary, t.processSummaryList)) : f[i] = { ...T(t), processSummary: j(t.processSummaryList || [], "name") };
      }
    }
    n.value = { artifactList: E(y), assembleList: E(c), partList: E(f) };
  }, summaryInfo: n };
}
function x(n, W) {
  if (W) for (const _ of W) n[_.name] ? n[_.name].quantity += _.quantity : n[_.name] = _;
}
const $e = { class: "common-step-warp" }, Qe = { class: "step-btn" }, qe = { __name: "detail", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(n, { emit: W }) {
  const _ = b(), y = W, c = n, { visible: f, handleClose: A } = pe({ emit: y, props: c, field: "visible", showHook: G }), { handleAssembleList: I, handleCompareAssembleList: d } = _e(), { handleSummaryData: u } = Ce(), s = b(0), h = b(false), k = b(false), V = b(false), t = b(), i = b({}), p = b({}), g = b({ artifact: {}, artifactPointWork: {}, assemble: {}, assemblePointWork: {} });
  q("changeInfo", t), q("taskInfo", i), q("schedulingInfo", p), q("schedulingHandle", g);
  const C = z(() => {
    var e, m, l, L;
    const a = [{ title: "变更原因", comp: Le }, { title: "变更详情", comp: ve }];
    return (m = (e = p.value) == null ? void 0 : e.assembleList) != null && m.length && a.push({ title: "部件任务变更下发", comp: ke }), (L = (l = p.value) == null ? void 0 : l.pointWorkTaskAssembleList) != null && L.length && a.push({ title: "部件点工下发", comp: we }), a;
  }), K = z(() => C.value[s.value].comp);
  ae(() => s.value, (a) => {
    document.querySelector(".common-step-warp") && (document.querySelector(".common-step-warp").querySelectorAll(".el-step")[a].scrollIntoView({ behavior: "smooth" }), a === 0 && document.querySelector(".common-step-warp").scrollTo(0, 0));
  });
  function G() {
    s.value = 0, X();
  }
  async function X() {
    try {
      t.value = {}, h.value = true;
      const { changeDTOList: a, attachmentList: e, changeReasonTypeEnum: m, remark: l } = await Te(c.info.id), L = a.map((o) => {
        var r;
        (r = o == null ? void 0 : o.changePartList) != null && r.length && (o.partCompareList = Y(o.changePartList)), o.assembleInfo = I(o.oldArtifact.assembleList || [], o.newArtifact.assembleList || []);
        const { assembleCompareList: S } = d(o.assembleInfo);
        return o.assembleCompareList = S, o.foldOpened = true, o;
      });
      t.value = { attachments: e, changeReasonTypeEnum: m, remark: l, changeList: L }, await J();
    } catch (a) {
      console.log(a, "获取详情失败");
    } finally {
      h.value = false;
    }
  }
  async function J() {
    var a;
    p.value = {}, g.value = { artifact: {}, artifactPointWork: {}, assemble: {}, assemblePointWork: {} };
    try {
      k.value = true;
      const e = await We(c.info.id);
      for (const m in e) (a = e[m]) != null && a.length && e[m].forEach((l) => {
        l.originQuantity = l.quantity, l.rowKey = ge();
      });
      p.value = { artifactList: e.artifactList || [], pointWorkTaskArtifactList: e.pointWorkTaskArtifactList || [], assembleList: e.assembleList || [], pointWorkTaskAssembleList: e.pointWorkTaskAssembleList || [] };
    } catch (e) {
      console.log(e, "获取变更list失败");
    } finally {
      k.value = false;
    }
  }
  function Y(a) {
    return a.map((e) => (e.changeType = e.changeTypeEnum, e.changeType & F.NEW.V && (e.newQuantity = e.changeQuantity || e.quantity, e.oldQuantity = e.oldQuantity || 0, e.diffQuantity = -(e.changeQuantity || e.quantity)), e.changeType & F.DEL.V && (e.newQuantity = e.changeQuantity || 0, e.oldQuantity = e.oldQuantity || e.quantity, e.diffQuantity = e.oldQuantity || e.quantity), e.diffQuantity && e.netWeight && (e.diffTotalWeight = (e.diffQuantity * e.netWeight).toFixed(he.COM_WT__KG)), e));
  }
  function Z() {
    var a;
    s.value === 1 && u((a = t.value) == null ? void 0 : a.changeList), s.value++;
  }
  async function ee() {
    var a, e, m, l, L, o, S;
    try {
      k.value = true;
      const r = [];
      if ((e = (a = p.value) == null ? void 0 : a.assembleList) != null && e.length) {
        const $ = g.value.assemble;
        if ((l = (m = g.value) == null ? void 0 : m.assembleNeedSchedulingList) != null && l.length) {
          le.warning("部件任务变更尚未全部处理完，请处理部件任务变更下发！");
          return;
        }
        if (ye($)) for (const D in $) for (const te in (L = $[D]) == null ? void 0 : L.handleObj) {
          const O = ((S = (o = $[D]) == null ? void 0 : o.handleObj) == null ? void 0 : S[te]) || {};
          r.push({ changeAssembleId: $[D].changeAssembleId, quantity: O.needSchedulingQuantity, groupsId: O.groupsId, askCompleteTime: O.askCompleteTime });
        }
      }
      await Ae({ changeId: c.info.id, assembleTaskList: r }), re.success("提交成功"), A();
    } catch (r) {
      console.log(r);
    } finally {
      k.value = false;
    }
  }
  return (a, e) => {
    const m = ce, l = H("common-button"), L = ue, o = H("common-drawer"), S = me;
    return R(), B(o, { ref_key: "drawerRef", ref: _, title: "清单变更", modelValue: P(f), "onUpdate:modelValue": e[2] || (e[2] = (r) => oe(f) ? f.value = r : null), direction: "rtl", "content-loading": h.value, "before-close": P(A), size: "100%", "custom-class": "change-record-detail" }, { titleAfter: v(() => [w(m, { effect: "plain", size: "large" }, { default: v(() => [Q("项目：" + M(n.info.project), 1)]), _: 1 }), w(m, { effect: "plain", size: "large" }, { default: v(() => {
      var r;
      return [Q("单体：" + M((r = n.info.monomer) == null ? void 0 : r.name), 1)];
    }), _: 1 })]), titleRight: v(() => e[3] || (e[3] = [])), content: v(() => [w(L, { class: "step-content" }, { default: v(() => [U("div", $e, [w(P(be), { modelValue: s.value, "onUpdate:modelValue": e[0] || (e[0] = (r) => s.value = r), options: C.value, "finish-status": "success", style: se(`width: ${200 * C.value.length}px`) }, null, 8, ["modelValue", "options", "style"])]), U("span", Qe, [w(l, { size: "default", plain: "", disabled: s.value === 0, onClick: e[1] || (e[1] = (r) => s.value--) }, { default: v(() => e[4] || (e[4] = [Q("上一步")])), _: 1, __: [4] }, 8, ["disabled"]), w(l, { size: "default", plain: "", disabled: s.value === C.value.length - 1, onClick: Z }, { default: v(() => e[5] || (e[5] = [Q("下一步")])), _: 1, __: [5] }, 8, ["disabled"]), w(l, { loading: k.value, size: "default", type: "warning", disabled: s.value !== C.value.length - 1, onClick: ee }, { default: v(() => e[6] || (e[6] = [Q(" 确认变更 ")])), _: 1, __: [6] }, 8, ["loading", "disabled"])])]), _: 1 }), ne((R(), B(ie(K.value), { "height-style": a.heightStyle }, null, 8, ["height-style"])), [[S, V.value]])]), _: 1 }, 8, ["modelValue", "content-loading", "before-close"]);
  };
} }, Ie = de(qe, [["__scopeId", "data-v-6da2d57a"]]), He = Object.freeze(Object.defineProperty({ __proto__: null, default: Ie }, Symbol.toStringTag, { value: "Module" }));
export {
  ze as c,
  He as d,
  Ie as m
};
