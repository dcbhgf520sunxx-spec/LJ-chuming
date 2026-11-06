import { useStore as J } from "vuex";
import { ref as P } from "vue";
import { watch as $ } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as g } from "vue";
import { createBlock as V } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as j } from "vue";
import { unref as t } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as H } from "vue";
import { createCommentVNode as C } from "vue";
import { createElementBlock as M } from "vue";
import { Fragment as W } from "vue";
import { createVNode as r } from "vue";
import { ElTabs as q } from "element-plus";
import { ElTabPane as T } from "element-plus";
import { isRef as K } from "vue";
import { ElMessageBox as Q } from "element-plus";
import { ElNotification as X } from "element-plus";
import { ElTag as Y } from "element-plus";
import { l as x, _ as Z, m as ee, u as te, dn as u, c3 as c, it as ae } from "../../../../shared/runtime.js";
import oe from "./base.vue.js";
import ne from "./business.vue.js";
import se from "./customer.vue.js";
import le from "./members.vue.js";
function ie(o) {
  return x({ module: "contract", url: "project/listChange", method: "get", params: o });
}
function re(o) {
  return x({ module: "contract", url: "project/getTempInfo", method: "get", params: o });
}
const be = { get: ie };
const ue = { class: "dialog-title" }, ce = { style: { position: "absolute", right: "20px" } }, de = { __name: "contractInfo", props: { auditStatus: [Number, String], modelValue: { type: Boolean, require: true }, showType: { type: String, default: void 0 }, detailInfo: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(o, { emit: O }) {
  const { globalProjectId: R } = ee(["globalProjectId"]), _ = J(), S = o, E = P("baseInfo"), U = O, { visible: v, handleClose: L } = te({ emit: U, props: S }), a = P({}), n = P({});
  $(() => v.value, (s) => {
    s && (a.value = {}, n.value = {}, S.detailInfo.id && F(S.detailInfo.id), E.value = "baseInfo");
  }, { deep: true, immediate: true });
  async function F(s) {
    var e, I, f, b, m, A, h, N, k, B;
    try {
      const { projectDto: d, projectTempDto: p } = await re({ changeId: s });
      d.projectContentName = (e = (d.projectContentList ?? []).map((l) => l.name)) == null ? void 0 : e.join("、"), p.projectContentName = (I = (p.projectContentList ?? []).map((l) => l.name)) == null ? void 0 : I.join("、"), d.relationUserId = (b = (f = d.relationUserList) == null ? void 0 : f.map((l) => l.id)) == null ? void 0 : b.join("、"), p.relationUserId = (A = (m = p.relationUserList) == null ? void 0 : m.map((l) => l.id)) == null ? void 0 : A.join("、"), d.relationUserName = (N = (h = d.relationUserList) == null ? void 0 : h.map((l) => l.name)) == null ? void 0 : N.join("、"), p.relationUserName = (B = (k = p.relationUserList) == null ? void 0 : k.map((l) => l.name)) == null ? void 0 : B.join("、"), a.value = p, n.value = d, a.value.enclosureInfo = { [u.STRUCTURE.V]: a.value.structureList || [], [u.PROFILED_PLATE.V]: a.value.profiledPlateList || [], [u.TRUSS_FLOOR_PLATE.V]: a.value.trussFloorPlateList || [], [u.PRESSURE_BEARING_PLATE.V]: a.value.pressureBearingPlateList || [], [u.SANDWICH_BOARD.V]: a.value.sandwichBoardList || [] }, n.value.enclosureInfo = { [u.STRUCTURE.V]: n.value.structureList || [], [u.PROFILED_PLATE.V]: n.value.profiledPlateList || [], [u.TRUSS_FLOOR_PLATE.V]: n.value.trussFloorPlateList || [], [u.PRESSURE_BEARING_PLATE.V]: n.value.pressureBearingPlateList || [], [u.SANDWICH_BOARD.V]: n.value.sandwichBoardList || [] }, a.value.userlist = a.value.relationUserIds ? a.value.relationUserIds.split(",") : [], n.value.userlist = n.value.relationUserIds ? n.value.relationUserIds.split(",") : [];
    } catch (d) {
      console.log("获取变更信息", d);
    }
  }
  const z = (s) => (!s || !s.trim()) && s !== 0 ? "必填" : s.length > 200 ? "长度在 1 到 200 个字符" : true;
  async function G() {
    try {
      await _.dispatch("project/fetchUserProjects"), await _.dispatch("project/fetchProjectTree"), R.value && await _.dispatch("project/setProjectId", R.value);
    } catch (s) {
      console.log(s);
    }
  }
  async function w(s) {
    try {
      const e = s === c.PASS.V ? "通过" : "驳回", I = await Q.prompt("请输入审核说明", e, { confirmButtonText: "确定", cancelButtonText: "取消", inputType: "textarea", inputValidator: z, type: "warning" }), f = { auditStatus: s, id: S.detailInfo.id, remark: I.value };
      await ae(f), X({ title: "提交成功", type: "success" }), s === c.PASS.V && G(), U("success"), L();
    } catch (e) {
      console.log("审核", e);
    }
  }
  return (s, e) => {
    const I = Y, f = D("common-button"), b = D("common-drawer");
    return g(), V(b, { "append-to-body": "", modelValue: t(v), "onUpdate:modelValue": e[3] || (e[3] = (m) => K(v) ? v.value = m : null), top: "10vh", width: "600px", "before-close": t(L), title: "合同信息变更", "wrapper-closable": false, size: "85%" }, { title: i(() => [j("div", ue, [e[7] || (e[7] = j("span", { class: "title-left" }, "合同信息变更", -1)), o.auditStatus ? (g(), V(I, { key: 0, size: "large", type: o.auditStatus == t(c).REJECT.V ? "info" : o.auditStatus == t(c).PASS.V ? "success" : "warning" }, { default: i(() => [y(H(o.auditStatus == t(c).REJECT.V ? "已驳回" : o.auditStatus == t(c).PASS.V ? "已通过" : "审核中"), 1)]), _: 1 }, 8, ["type"])) : C("", true), j("span", ce, [o.auditStatus && t(v) ? (g(), M(W, { key: 0 }, [o.auditStatus == t(c).AUDITING.V && o.showType === "audit" ? (g(), V(f, { key: 0, size: "default", type: "info", onClick: e[0] || (e[0] = (m) => w(t(c).REJECT.V)) }, { default: i(() => e[4] || (e[4] = [y("驳回")])), _: 1, __: [4] })) : C("", true), o.auditStatus == t(c).AUDITING.V && o.showType === "audit" ? (g(), V(f, { key: 1, size: "default", type: "success", onClick: e[1] || (e[1] = (m) => w(t(c).PASS.V)) }, { default: i(() => e[5] || (e[5] = [y("通过")])), _: 1, __: [5] })) : C("", true)], 64)) : C("", true), r(f, { size: "default", onClick: t(L) }, { default: i(() => e[6] || (e[6] = [y("关闭")])), _: 1, __: [6] }, 8, ["onClick"])])])]), content: i(() => [r(t(q), { modelValue: E.value, "onUpdate:modelValue": e[2] || (e[2] = (m) => E.value = m) }, { default: i(() => [r(t(T), { label: "基础信息", name: "baseInfo" }, { default: i(() => [r(t(oe), { ref: "baseRef", class: "tab-content", detail: a.value, originContractInfo: n.value }, null, 8, ["detail", "originContractInfo"])]), _: 1 }), r(t(T), { label: "商务信息", name: "businessInfo" }, { default: i(() => [r(t(ne), { ref: "businessRef", class: "tab-content", detail: a.value, originContractInfo: n.value }, null, 8, ["detail", "originContractInfo"])]), _: 1 }), r(t(T), { label: "客户信息", name: "customerInfo" }, { default: i(() => [r(t(se), { ref: "customerRef", class: "tab-content", detail: a.value, originContractInfo: n.value }, null, 8, ["detail", "originContractInfo"])]), _: 1 }), r(t(T), { label: "项目成员", name: "memberInfo" }, { default: i(() => [r(t(le), { ref: "memberRef", checkedList: a.value.userlist, detail: a.value, originContractInfo: n.value }, null, 8, ["checkedList", "detail", "originContractInfo"])]), _: 1 })]), _: 1 }, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, fe = Z(de, [["__scopeId", "data-v-9272cd4d"]]), Ve = Object.freeze(Object.defineProperty({ __proto__: null, default: fe }, Symbol.toStringTag, { value: "Module" }));
export {
  fe as a,
  Ve as b,
  be as c
};
