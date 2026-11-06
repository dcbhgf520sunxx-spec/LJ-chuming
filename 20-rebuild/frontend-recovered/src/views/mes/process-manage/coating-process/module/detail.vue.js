import { useStore as W } from "vuex";
import { ref as P } from "vue";
import { computed as x } from "vue";
import { watch as X } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as Z } from "vue";
import { openBlock as c } from "vue";
import { createBlock as f } from "vue";
import { withCtx as n } from "vue";
import { createElementBlock as v } from "vue";
import { Fragment as A } from "vue";
import { createTextVNode as y } from "vue";
import { unref as a } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as g } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as u } from "vue";
import { withDirectives as ee } from "vue";
import { ElMessageBox as R } from "element-plus";
import { ElNotification as ae } from "element-plus";
import { ElTag as te } from "element-plus";
import { ElPopover as ne } from "element-plus";
import { ElPopconfirm as le } from "element-plus";
import { ElDescriptionsItem as oe } from "element-plus";
import { ElDescriptions as ie } from "element-plus";
import { ElInput as se } from "element-plus";
import { _ as re, gt as pe, ib as b, oz as ce, G as h, ow as ue, p as L, bY as de, bV as U, oA as me, oB as fe } from "../../../../../shared/runtime.js";
const ge = { key: 0, style: { color: "red" } }, _e = { key: 1, class: "footer" }, ve = { class: "print-table-style" }, ye = { key: 0 }, be = { key: 1 }, we = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false }, componentName: { type: [String, Number], default: void 0 }, journalId: { type: [String, Number], default: void 0 } }, emits: ["auditSuccess", "secondaryEdit"], setup(_, { emit: j }) {
  const G = W(), { crud: d, detail: t } = pe(), D = j, S = P(), E = P(), N = x(() => t.boolInvalid && t.approvalStatus === b.PASS.V), F = x(() => t.boolInvalid && t.approvalStatus === b.AUDITING.V), $ = x(() => t.approvalStatus === b.AUDITING.V);
  async function q() {
    try {
      await R.confirm("是否确认二次编辑？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const m = JSON.parse(JSON.stringify(t));
      D("secondaryEdit", m), d.cancelDetail();
    } catch (m) {
      console.log("二次编辑", m);
    }
  }
  async function J() {
    try {
      await R.confirm("您选择了作废操作，是否确认？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await me({ id: t == null ? void 0 : t.id }), d.refresh(), d.cancelDetail(), await G.dispatch("approval_list/fetchApprovalNum"), ae({ title: "作废审核提交成功", type: "success", duration: 3e3 });
    } catch (m) {
      console.log("作废审核", m);
    }
  }
  async function C(m) {
    try {
      E.value = true;
      const i = { id: t.id, status: m, opinion: S.value };
      await fe(i), D("auditSuccess");
    } catch (i) {
      console.log("涂装工艺审核提交", i);
    } finally {
      E.value = false;
    }
  }
  return X(() => d.detailVisible, (m) => {
    S.value = void 0;
  }, { deep: true, immediate: true }), (m, i) => {
    const V = te, w = T("common-button"), M = ne, I = le, O = T("print-table"), r = oe, B = ie, Y = se, H = T("common-drawer"), K = Z("permission");
    return c(), f(H, { ref: "drawerRef", "before-close": a(d).cancelDetail, "content-loading": a(d).detailLoading, "show-close": true, title: "工艺明细单", visible: a(d).detailVisible, size: "55%" }, { titleAfter: n(() => {
      var l, e;
      return [_.ApprovalFlag ? g("", true) : (c(), v(A, { key: 0 }, [N.value ? (c(), f(V, { key: 0, type: "danger", effect: "plain" }, { default: n(() => i[3] || (i[3] = [y(" 已作废 ")])), _: 1, __: [3] })) : F.value ? (c(), f(V, { key: 1, type: "warning", effect: "plain" }, { default: n(() => i[4] || (i[4] = [y(" 作废审批中 ")])), _: 1, __: [4] })) : (c(), f(V, { key: 2, type: (e = a(b).V[(l = a(t)) == null ? void 0 : l.approvalStatus]) == null ? void 0 : e.TAG, effect: "plain" }, { default: n(() => {
        var s;
        return [y(p(a(b).VL[(s = a(t)) == null ? void 0 : s.approvalStatus] || "-"), 1)];
      }), _: 1 }, 8, ["type"]))], 64)), _.ApprovalFlag ? (c(), v(A, { key: 1 }, [F.value ? (c(), v("div", ge, "作废申请，审批通过后该数据将作废！")) : g("", true)], 64)) : g("", true)];
    }), titleRight: n(() => {
      var l, e;
      return [((e = (l = a(t)) == null ? void 0 : l.approveRecord) == null ? void 0 : e.length) !== 0 ? (c(), f(M, { key: 0, width: 400, placement: "bottom", trigger: "click" }, { reference: n(() => [o(w, { size: "default" }, { default: n(() => i[5] || (i[5] = [y("查看审批记录")])), _: 1, __: [5] })]), default: n(() => {
        var s;
        return [o(a(ce), { data: ((s = a(t)) == null ? void 0 : s.approveRecord) || [] }, null, 8, ["data"])];
      }), _: 1 })) : g("", true), _.ApprovalFlag ? (c(), v("div", _e, [o(I, { title: "确认通过", onConfirm: i[0] || (i[0] = (s) => C(a(b).PASS.V)) }, { reference: n(() => [o(w, { loading: E.value, class: "filter-item", size: "default", type: "success" }, { default: n(() => i[6] || (i[6] = [y("通过")])), _: 1, __: [6] }, 8, ["loading"])]), _: 1 }), o(I, { title: "确认驳回", onConfirm: i[1] || (i[1] = (s) => C(a(b).REFUSE.V)) }, { reference: n(() => [o(w, { loading: E.value, class: "filter-item", size: "default", type: "danger" }, { default: n(() => i[7] || (i[7] = [y(" 驳回")])), _: 1, __: [7] }, 8, ["loading"])]), _: 1 })])) : g("", true), !_.ApprovalFlag && !N.value && !$.value ? (c(), v(A, { key: 2 }, [a(h)(a(d).permission.secondaryEdit) ? (c(), f(w, { key: 0, type: "warning", size: "default", onClick: q }, { default: n(() => i[8] || (i[8] = [y(" 二次编辑 ")])), _: 1, __: [8] })) : g("", true), a(h)(a(d).permission.cancellation) ? (c(), f(w, { key: 1, type: "danger", size: "default", onClick: J }, { default: n(() => i[9] || (i[9] = [y(" 作废 ")])), _: 1, __: [9] })) : g("", true)], 64)) : g("", true)];
    }), content: n(() => [u("div", ve, [ee(o(O, { "api-key": "paintingCraftListDetailPrint", params: { id: a(t).id }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[K, a(ue).detailsPrint]])]), o(B, { data: a(t), column: 12, size: "large", border: "", style: { "margin-bottom": "20px" } }, { default: n(() => [o(r, { align: "center", label: "项目：", span: 4 }, { default: n(() => {
      var l, e, s, k;
      return [u("span", null, p((e = (l = a(t)) == null ? void 0 : l.project) == null ? void 0 : e.serialNumber) + " - " + p((k = (s = a(t)) == null ? void 0 : s.project) == null ? void 0 : k.shortName), 1)];
    }), _: 1 }), o(r, { align: "center", label: "单体：", span: 4 }, { default: n(() => {
      var l, e, s, k, z;
      return [(e = (l = a(t)) == null ? void 0 : l.monomerList) != null && e.length ? (c(), v("span", ye, p((z = (k = (s = a(t)) == null ? void 0 : s.monomerList) == null ? void 0 : k.map((Q) => Q.name)) == null ? void 0 : z.join("、")), 1)) : (c(), v("span", be, "-"))];
    }), _: 1 }), o(r, { align: "center", label: "工艺编号：", span: 4 }, { default: n(() => {
      var l;
      return [u("span", null, p(((l = a(t)) == null ? void 0 : l.serialNumber) || "-"), 1)];
    }), _: 1 }), o(r, { align: "center", label: "创建人：", span: _.ApprovalFlag ? 4 : 3 }, { default: n(() => {
      var l, e;
      return [u("span", null, p(((e = (l = a(t)) == null ? void 0 : l.createUser) == null ? void 0 : e.name) || "-"), 1)];
    }), _: 1 }, 8, ["span"]), o(r, { align: "center", label: "创建日期：", span: _.ApprovalFlag ? 4 : 3 }, { default: n(() => {
      var l, e;
      return [u("span", null, p((l = a(t)) != null && l.createDate ? a(L)((e = a(t)) == null ? void 0 : e.createDate, "{y}-{m}-{d}") : "-"), 1)];
    }), _: 1 }, 8, ["span"]), _.ApprovalFlag ? (c(), f(r, { key: 1, align: "center", label: "", span: 4 })) : (c(), v(A, { key: 0 }, [o(r, { align: "center", label: "审核人：", span: 3 }, { default: n(() => {
      var l, e;
      return [u("span", null, p(((e = (l = a(t)) == null ? void 0 : l.approvalUser) == null ? void 0 : e.name) || "-"), 1)];
    }), _: 1 }), o(r, { align: "center", label: "审核日期：", span: 3 }, { default: n(() => {
      var l, e;
      return [u("span", null, p((l = a(t)) != null && l.approvalTime ? a(L)((e = a(t)) == null ? void 0 : e.approvalTime, "{y}-{m}-{d}") : "-"), 1)];
    }), _: 1 })], 64))]), _: 1 }, 8, ["data"]), o(B, { data: a(t), column: 3, size: "large", border: "" }, { default: n(() => {
      var l;
      return [o(r, { align: "center", label: "油漆类型" }, { default: n(() => {
        var e, s;
        return [u("span", null, p((e = a(t)) != null && e.paintingTypeEnum ? a(de).VL[(s = a(t)) == null ? void 0 : s.paintingTypeEnum] : "-"), 1)];
      }), _: 1 }), o(r, { align: "center", label: "材质" }, { default: n(() => {
        var e;
        return [u("span", null, p(((e = a(t)) == null ? void 0 : e.paintType) || "-"), 1)];
      }), _: 1 }), o(r, { align: "center", label: "品牌" }, { default: n(() => {
        var e;
        return [u("span", null, p(((e = a(t)) == null ? void 0 : e.paintBrand) || "-"), 1)];
      }), _: 1 }), o(r, { align: "center", label: "表面积（㎡）" }, { default: n(() => {
        var e;
        return [u("span", null, p(((e = a(t)) == null ? void 0 : e.surfaceArea) || "-"), 1)];
      }), _: 1 }), o(r, { align: "center", label: "漆膜厚度（μm）" }, { default: n(() => {
        var e;
        return [u("span", null, p(((e = a(t)) == null ? void 0 : e.paintFilmThickness) || "-"), 1)];
      }), _: 1 }), o(r, { align: "center", label: "损耗系数" }, { default: n(() => {
        var e;
        return [u("span", null, p(((e = a(t)) == null ? void 0 : e.lossCoefficient) || "-"), 1)];
      }), _: 1 }), o(r, { align: "center", label: `数量（${((l = a(t)) == null ? void 0 : l.packageUnit) || "/"}）` }, { default: n(() => {
        var e, s;
        return [u("span", null, p(((s = (e = a(t)) == null ? void 0 : e.quantity) == null ? void 0 : s.toFixed(2)) || "-"), 1)];
      }), _: 1 }, 8, ["label"]), o(r, { align: "center", label: "重量（kg）" }, { default: n(() => {
        var e, s;
        return [u("span", null, p(((s = (e = a(t)) == null ? void 0 : e.weight) == null ? void 0 : s.toFixed(2)) || "-"), 1)];
      }), _: 1 }), o(r, { align: "center", label: "单价（元）" }, { default: n(() => {
        var e;
        return [u("span", null, p(a(U)((e = a(t)) == null ? void 0 : e.unitPrice, 2) || "-"), 1)];
      }), _: 1 }), o(r, { align: "center", label: "金额（元）" }, { default: n(() => {
        var e;
        return [u("span", null, p(a(U)((e = a(t)) == null ? void 0 : e.totalPrice, 2) || "-"), 1)];
      }), _: 1 }), o(r, { align: "center", label: "" }), o(r, { align: "center", label: "" })];
    }), _: 1 }, 8, ["data"]), _.ApprovalFlag ? (c(), f(Y, { key: 0, modelValue: S.value, "onUpdate:modelValue": i[2] || (i[2] = (l) => S.value = l), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "20px" }, autosize: { minRows: 3, maxRows: 3 }, type: "textarea" }, null, 8, ["modelValue"])) : g("", true)]), _: 1 }, 8, ["before-close", "content-loading", "visible"]);
  };
} }, Ee = re(we, [["__scopeId", "data-v-aadaff28"]]);
export {
  Ee as default
};
