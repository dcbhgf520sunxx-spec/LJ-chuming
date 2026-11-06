function Cyt(e) {
  return W({ url: "/api/wms/nesting-docking/countLength", method: "get", params: e });
}
function Pyt(e) {
  return W({ module: "mes", url: "team/partCutConfigTeamList", method: "get", params: e });
}
function Oyt(e) {
  return W({ module: "mes", url: "machine_part/nesting/manually-processing-machine-part-issued-to-nesting-software-abnormal-data", method: "put", data: e });
}
function kyt(e) {
  return W({ module: "mes", url: "nesting-result/get-job-tree", method: "get", params: e });
}
function Dyt(e) {
  return W({ module: "mes", url: "machine_part/nesting/get-project-list", method: "get", params: e });
}
function xyt(e) {
  return W({ module: "mes", url: "nesting-result/job-steel-plate/list", method: "get", params: e });
}
function Uyt(e) {
  return W({ module: "mes", url: "nesting-result/job-machine-part-summary", method: "get", params: e });
}
function Yyt(e) {
  return W({ module: "mes", url: "nesting-result/job-steel-plate/delete", method: "delete", data: e });
}
function Kyt(e) {
  return W({ module: "mes", url: "nesting-result/job-steel-plate/secondary-scheduling", method: "post", data: e });
}
function Wyt(e) {
  return W({ module: "mes", url: "nesting-result/job-steel-plate/batch-download-report-form", method: "get", responseType: "blob", params: e });
}
function jyt(e) {
  return W({ module: "mes", url: "nesting-result/job-steel-plate/scheduling-revoke", method: "post", data: e });
}
const Fyt = { get: Npe };
const kpe = { class: "footer" }, Dpe = { class: "total-info" }, xpe = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const { crud: n, detail: c } = qi(), u = o, r = e, E = Z(), y = Z(), b = Ee(() => {
    var _, f, m, R;
    return (R = (m = (f = (_ = c.wmsApproveRecordFlowDTO) == null ? void 0 : _.wmsApproveFlowDTOS) == null ? void 0 : f[0]) == null ? void 0 : m.wmsApproveRecordDetailDTOS) == null ? void 0 : R[0];
  }), V = Ee(() => {
    var _;
    return (_ = c.orderNumber) == null ? void 0 : _.includes("(型)");
  }), M = Ee(() => {
    var _;
    return (_ = c.orderNumber) == null ? void 0 : _.includes("(直)");
  }), g = Ee(() => V.value || M.value ? c.semiAutoCutPartDTOList : c.appautoCutPlateDTOList), S = Z(), { maxHeight: h } = Kt({ extraBox: [".el-drawer__header", ".total-info"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, S);
  async function T(_) {
    try {
      if (y.value = true, V.value || M.value) {
        const f = { id: c.rowDetail.journalId, serialNumber: c.serialNumber, decision: 2 };
        await Ppe(f);
      } else {
        const f = { wmsApproveRecordId: c.rowDetail.dataId };
        await Ope(f);
      }
      u("auditSuccess");
    } catch (f) {
      console.log("零件排产审核提交", f);
    } finally {
      y.value = false;
    }
  }
  return Ce(() => n.detailVisible, (_) => {
    console.log(c, "detail"), E.value = void 0;
  }, { deep: true, immediate: true }), (_, f) => {
    const m = Ve("common-button"), R = pa, v = qa, N = Ga, P = vt, L = Ve("common-table"), O = Ve("common-drawer");
    return w(), U(O, { ref_key: "drawerRef", ref: S, "before-close": l(n).cancelDetail, "content-loading": l(n).detailLoading, "show-close": true, title: "领料申请", visible: l(n).detailVisible, size: "65%" }, { titleAfter: p(() => f[1] || (f[1] = [])), titleRight: p(() => [C("div", kpe, [r.ApprovalFlag ? (w(), U(R, { key: 0, title: "确认通过", onConfirm: f[0] || (f[0] = (x) => T(l(Lt).PASS.V)) }, { reference: p(() => [s(m, { loading: y.value, class: "filter-item", size: "default", type: "success" }, { default: p(() => f[2] || (f[2] = [Te("通过")])), _: 1, __: [2] }, 8, ["loading"])]), _: 1 })) : H("", true)])]), content: p(() => [C("div", Dpe, [s(N, { data: l(c), column: 12, size: "large", border: "", style: { "margin-bottom": "20px" } }, { default: p(() => [s(v, { align: "center", label: "项目名称：", span: 4 }, { default: p(() => [C("span", null, K(l(c).projectName), 1)]), _: 1 }), s(v, { align: "center", label: "车间名称：", span: 4 }, { default: p(() => [C("span", null, K(l(c).workshopName), 1)]), _: 1 }), s(v, { align: "center", label: "工单号：", span: 4 }, { default: p(() => [C("span", null, K(l(c).orderNumber), 1)]), _: 1 }), s(v, { align: "center", label: "总重量(kg)：", span: 4 }, { default: p(() => [C("span", null, K(V.value || M.value ? l(c).totalNetWeight : parseFloat(l(c).totalNetWeight / 1e3).toFixed(2)), 1)]), _: 1 }), s(v, { align: "center", label: "领料人", span: 4 }, { default: p(() => {
      var x, I;
      return [C("span", null, K((I = (x = b.value) == null ? void 0 : x.userSimpleResponseVOS) == null ? void 0 : I.name), 1)];
    }), _: 1 }), s(v, { align: "center", label: "日期：", span: 4 }, { default: p(() => {
      var x;
      return [C("span", null, K(l(Qi)((x = b.value) == null ? void 0 : x.approveTime, "{y}-{m}-{d}")), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data"])]), s(L, { data: g.value, "max-height": l(h), "empty-text": "暂无数据", style: { width: "100%" } }, { default: p(() => [s(P, { label: "序号", type: "index", align: "center", width: "60" }), V.value ? (w(), U(P, { key: 0, label: "类型", prop: "partType" })) : (w(), U(P, { key: 1, label: "类型", prop: "materialIsWhole" }, { default: p(() => [f[3] || (f[3] = Te(K("钢板")))]), _: 1 })), V.value ? H("", true) : (w(), U(P, { key: 2, label: "厚度", prop: "thickness" })), M.value ? H("", true) : (w(), U(P, { key: 3, label: "规格" }, { default: p((x) => [Te(K(V.value ? x.row.specification : `${x.row.thickness} * ${x.row.width} * ${x.row.length}`), 1)]), _: 1 })), s(P, { label: "材质" }, { default: p((x) => [Te(K(V.value || M.value ? x.row.material : x.row.specification), 1)]), _: 1 }), s(P, { label: "计量单位" }, { default: p(() => [Te(K(V.value ? "米" : M.value ? "-" : "张"), 1)]), _: 1 }), s(P, { label: "数量" }, { default: p((x) => [Te(K(V.value ? x.row.totalLength : x.row.quantity), 1)]), _: 1 }), s(P, { label: "单位" }, { default: p(() => [f[4] || (f[4] = Te(K("kg")))]), _: 1 }), s(P, { label: "核算量" }, { default: p((x) => [Te(K(V.value || M.value ? x.row.totalNetWeight : parseFloat(x.row.mete / 1e3).toFixed(2)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["before-close", "content-loading", "visible"]);
  };
} }, x8 = ut(xpe, [["__scopeId", "data-v-d9de8a6f"]]), Upe = Object.freeze(Object.defineProperty({ __proto__: null, default: x8 }, Symbol.toStringTag, { value: "Module" }));
function Ype(e) {
  return W({ url: "/api/wms/picking/approve/record", method: "get", params: e });
}
function U8(e) {
  return W({ url: `/api/wms/picking/approve/selectById/${e}`, method: "get" });
}
function Kpe(e) {
  return W({ url: "/api/wms/picking/approve/review", method: "put", params: e });
}
function Wpe(e) {
  return W({ url: "/api/wms/picking/approve/revocation", method: "put", params: e });
}
const zyt = { get: Ype, detail: U8 }, Y8 = { __name: "outbound-detail", props: { visible: { type: Boolean, require: true }, currentRow: { type: Object, default: () => {
} }, maxHeight: { type: Number, default: 100 } }, emits: ["success", "update:visible", "update:modelValue"], setup(e, { emit: o }) {
  const n = o, c = e, { visible: u, handleClose: r } = Ta({ emit: n, props: c });
  function E(y) {
    return Hi(y, { props: ["quantity", "pickingOutSumMete"] });
  }
  return (y, b) => {
    const V = wi, M = vt, g = Ve("common-table"), S = Ve("common-drawer");
    return w(), U(S, { ref: "drawerRef", modelValue: l(u), "onUpdate:modelValue": b[0] || (b[0] = (h) => Gt(u) ? u.value = h : null), "before-close": l(r), title: "出库明细", "show-close": true, "close-on-click-modal": false, size: "70%", "custom-class": "raw-mat-application-review-form" }, { titleAfter: p(() => [s(V, null, { default: p(() => [Te("工单号：" + K(e.currentRow.taskOrderNumber || "-"), 1)]), _: 1 })]), content: p(() => [s(g, { data: e.currentRow.wmsPickingApproveDetailDTOList, "max-height": e.maxHeight - 50, "show-summary": "", "summary-method": E }, { default: p(() => [s(M, { align: "center", label: "序号", type: "index", width: "60" }), s(M, { key: "serialNumber", align: "center", label: "物料编号", "min-width": "100px", prop: "serialNumber" }), s(M, { key: "classifyName", align: "center", label: "物料种类", "min-width": "100px", prop: "classifyName" }), s(M, { key: "specificationInfo", align: "center", label: "规格", prop: "specificationInfo", "min-width": "150px" }), s(M, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", width: "80" }), s(M, { key: "quantity", prop: "quantity", label: "数量", "min-width": "80px", align: "center" }), s(M, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", width: "80px" }), s(M, { key: "pickingOutSumMete", align: "center", label: "核算量", prop: "pickingOutSumMete", "min-width": "80px" })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, jpe = Object.freeze(Object.defineProperty({ __proto__: null, default: Y8 }, Symbol.toStringTag, { value: "Module" }));
const Fpe = { key: 0, class: "footer" }, zpe = ["onClick"], Bpe = { key: 1 }, Hpe = { key: 0 }, qpe = { key: 1 }, Gpe = { key: 0 }, Qpe = { key: 1 }, Zpe = ["onClick"], Jpe = { key: 1 }, Xpe = { key: 0 }, $pe = { key: 1 }, ehe = { key: 0 }, the = { key: 1 }, ihe = ["onClick"], ahe = { key: 1 }, lhe = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false }, componentName: { type: [String, Number], default: void 0 }, journalId: { type: [String, Number], default: void 0 } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = Z({}), c = Z(1), u = Z(false), r = Ee(() => n.value === Ge.SECTION_STEEL.V ? [{ value: 1, name: "重量" }, { value: 2, name: "长度" }] : [{ value: 1, name: "重量" }, { value: 2, name: "面积" }]), E = o, y = e, b = Z(), V = Z(), M = Z(false), g = Z({}), S = Z([...Da, ["outboundAddress", ["parse-enum", So]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), { CRUD: h, crud: T, detail: _ } = qi(), { maxHeight: f } = Kt({ mainBox: ".receipt-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => Ee(() => !T.detailLoading)), m = Ee(() => "排产出库单");
  h.HOOK.beforeDetailLoaded = async (P, L) => {
    V.value = void 0, n.value = L.materialType === "型材" ? Ge.SECTION_STEEL.V : Ge.STEEL_PLATE.V;
    const O = [], x = [];
    L.wmsPickingDetailDTO.map(async (I) => {
      if (I.basicClass = n.value, I.basicClass & va.STEEL.V && (I.measureUnit = vi[I.basicClass].measure.unit, I.measurePrecision = vi[I.basicClass].measure.precision, I.accountingUnit = vi[I.basicClass].weight.unit, I.volume && (I.volume = St(I.volume, "g", ei.weight.unit, ei.weight.precision)), I.nowMete && (I.nowMete = St(I.nowMete, "g", ei.weight.unit, ei.weight.precision))), I.wmsPickingApproveDetailDTOList.forEach((Y) => {
        Y.quantity = Y.pickingOutSumQuantity, Y.width = Y.outWidth, Y.thickness = Y.outThickness, Y.length = Y.outLength, Y.specification = Y.outSpecification, Y.specificationInfo = Ki(Y);
      }), A(I.wmsPickingApproveDetailDTOList)) {
        const Y = await Qt(I.wmsPickingApproveDetailDTOList), ee = await Ut(I.wmsPickingApproveDetailDTOList, { toSmallest: false, toNum: true }, { mete: ["pickingOutSumMete"] });
        O.push(Y), x.push(ee);
      }
    }), await Promise.all(O), await Promise.all(x);
  };
  function R(P) {
    g.value = P, u.value = true;
  }
  function v(P) {
    const { columns: L, data: O } = P, x = [];
    return L.forEach((I, Y) => {
      if (Y === 0) {
        x[Y] = "合计";
        return;
      }
      const ee = ["quantity", "mete", "pickingAmount", "pickingArea", "pickingLength", "volume", "handlingArea", "handlingLength", "nowMete", "nowArea", "nowLength"], B = ["pickingArea", "handlingArea", "nowArea"], q = ["pickingLength", "handlingLength", "nowLength"];
      if (ee.includes(I.property)) {
        const ae = O.map((j) => {
          var le;
          return (le = j.sourceRow) == null ? void 0 : le[I.property];
        });
        ae.every((j) => isNaN(j)) || (x[Y] = ae.reduce((j, le) => {
          const oe = Number(le);
          return isNaN(oe) ? j : j + le;
        }, 0), B.includes(I.property) ? x[Y] = St(x[Y], "mm²", "㎡", 4) : q.includes(I.property) && (x[Y] = St(x[Y], "mm", "m", 3)));
      }
    }), x;
  }
  async function N(P) {
    try {
      if (M.value = true, P === Lt.REFUSE.V && !A(V.value)) {
        ot.error("请输入审批意见");
        return;
      }
      const L = { approveRecordId: _.approveRecordId, decision: P, opinion: V.value };
      await Kpe(L), P === Lt.PASS.V ? ot.success("审批通过") : ot.error("审批驳回"), E("auditSuccess");
    } catch (L) {
      console.log("排产出库审核提交", L);
    } finally {
      M.value = false;
    }
  }
  return (P, L) => {
    const O = wi, x = Ve("common-button"), I = La, Y = pa, ee = Ve("common-radio-button"), B = vt, q = Fo, ae = Ve("common-table"), j = Mt, le = Ve("common-drawer");
    return w(), U(le, { ref_key: "drawerRef", ref: b, "before-close": l(T).cancelDetail, "content-loading": l(T).detailLoading, "show-close": true, title: m.value, visible: l(T).detailVisible, "custom-class": "receipt-record-detail", size: "85%" }, { titleAfter: p(() => {
      var oe, ye;
      return [l(_).applicantName ? (w(), U(O, { key: 0, effect: "dark" }, { default: p(() => [Te(K(`申请人：${l(_).applicantName}`), 1)]), _: 1 })) : H("", true), l(_).createTime ? (w(), U(O, { key: 1, effect: "plain", type: "warning" }, { default: p(() => [Te(K(`出库申请时间：${l(Qi)(l(_).createTime)}`), 1)]), _: 1 })) : H("", true), l(_).reviewStatus ? (w(), U(O, { key: 2, size: "default", type: (oe = l(Lt).V[l(_).reviewStatus]) == null ? void 0 : oe.TAG }, { default: p(() => [Te(K(l(Lt).VL[l(_).reviewStatus]), 1)]), _: 1 }, 8, ["type"])) : H("", true), ((ye = l(_).wmsApproveRecordFlowDTO) == null ? void 0 : ye.length) !== 0 ? (w(), U(I, { key: 3, width: 400, placement: "bottom", trigger: "hover" }, { reference: p(() => [s(x, { size: "default" }, { default: p(() => L[5] || (L[5] = [Te("查看审批记录")])), _: 1, __: [5] })]), default: p(() => [s(tl, { data: l(_).wmsApproveRecordFlowDTO || [] }, null, 8, ["data"])]), _: 1 })) : H("", true)];
    }), titleRight: p(() => [y.ApprovalFlag ? (w(), Q("div", Fpe, [s(Y, { title: "确认通过", onConfirm: L[0] || (L[0] = (oe) => N(l(Lt).PASS.V)) }, { reference: p(() => [s(x, { loading: M.value, class: "filter-item", size: "default", type: "success" }, { default: p(() => L[6] || (L[6] = [Te("通过")])), _: 1, __: [6] }, 8, ["loading"])]), _: 1 }), s(Y, { title: "确认驳回", onConfirm: L[1] || (L[1] = (oe) => N(l(Lt).REFUSE.V)) }, { reference: p(() => [s(x, { loading: M.value, class: "filter-item", size: "default", type: "danger" }, { default: p(() => L[7] || (L[7] = [Te(" 驳回")])), _: 1, __: [7] }, 8, ["loading"])]), _: 1 })])) : H("", true)]), content: p(() => [s(ee, { modelValue: c.value, "onUpdate:modelValue": L[2] || (L[2] = (oe) => c.value = oe), options: r.value, type: "other", dataStructure: { key: "value", label: "name", value: "value" }, size: "default", style: { "margin-bottom": "5px" } }, null, 8, ["modelValue", "options"]), s(ae, { data: l(_).wmsPickingDetailDTO, "data-format": S.value, "max-height": l(f), "show-summary": "", "summary-method": v, "row-key": "id" }, { default: p(() => [s(B, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), s(B, { key: "project", prop: "project", label: "项目", align: "left", "show-overflow-tooltip": "", "min-width": "150" }), s(B, { key: "taskOrderNumber", prop: "taskOrderNumber", label: "领料单", align: "center", "show-overflow-tooltip": "", "min-width": "150" }), s(B, { key: "mesWorkshop.name", prop: "mesWorkshop.name", label: "车间", align: "center", "show-overflow-tooltip": "" }), s(B, { key: "pickingType", align: "center", label: "领料类型", prop: "pickingType", "show-overflow-tooltip": "", width: "100" }), n.value === l(Ge).SECTION_STEEL.V ? (w(), U(B, { key: "specification", label: "规格", align: "center", prop: "specification", "show-overflow-tooltip": "", "min-width": "120px" })) : H("", true), n.value === l(Ge).STEEL_PLATE.V ? (w(), U(B, { key: "thick", label: "厚度(mm)", align: "center", prop: "thick", "show-overflow-tooltip": "", width: "100px" })) : H("", true), s(B, { key: "material", align: "left", label: "材质", prop: "material", "show-overflow-tooltip": "", "min-width": "90" }), c.value === 1 ? (w(), U(B, { key: "unit", prop: "unit", label: "单位", align: "center", width: "80px" })) : H("", true), c.value === 1 ? (w(), Q(Qe, { key: 3 }, [s(B, { key: "pickingAmount", prop: "pickingAmount", label: "领料量", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }), s(B, { label: "已办理量", "show-overflow-tooltip": "", "min-width": "90px", key: "volume", prop: "volume", align: "center" }), s(B, { label: "本次办理量", "show-overflow-tooltip": "", "min-width": "90px", key: "nowMete", prop: "nowMete", align: "center" }, { default: p(({ row: { sourceRow: oe } }) => [oe.nowMete ? (w(), Q("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: (ye) => R(oe) }, K(oe.nowMete), 9, zpe)) : (w(), Q("span", Bpe, "-"))]), _: 1 })], 64)) : H("", true), c.value === 2 ? (w(), Q(Qe, { key: 4 }, [n.value === l(Ge).STEEL_PLATE.V ? (w(), Q(Qe, { key: 0 }, [s(B, { key: "pickingArea", prop: "pickingArea", label: "领料面积(㎡)", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }, { default: p(({ row: { sourceRow: oe } }) => [oe.pickingArea ? (w(), Q("span", Hpe, K(l(St)(oe.pickingArea, "mm²", "㎡", 4)), 1)) : (w(), Q("span", qpe, "-"))]), _: 1 }), s(B, { label: "已办理面积(㎡)", "show-overflow-tooltip": "", "min-width": "90px", key: "handlingArea", prop: "handlingArea", align: "center" }, { default: p(({ row: { sourceRow: oe } }) => [oe.handlingArea ? (w(), Q("span", Gpe, K(l(St)(oe.handlingArea, "mm²", "㎡", 4)), 1)) : (w(), Q("span", Qpe, "-"))]), _: 1 }), s(B, { label: "本次办理面积(㎡)", "show-overflow-tooltip": "", "min-width": "90px", key: "nowArea", prop: "nowArea", align: "center" }, { default: p(({ row: { sourceRow: oe } }) => [oe.nowArea ? (w(), Q("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: (ye) => R(oe) }, K(l(St)(oe.nowArea, "mm²", "㎡", 4)), 9, Zpe)) : (w(), Q("span", Jpe, "-"))]), _: 1 })], 64)) : (w(), Q(Qe, { key: 1 }, [s(B, { key: "pickingLength", prop: "pickingLength", label: "领用长度(m)", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }, { default: p(({ row: { sourceRow: oe } }) => [oe.pickingLength ? (w(), Q("span", Xpe, K(l(St)(oe.pickingLength, "mm", "m", 3)), 1)) : (w(), Q("span", $pe, "-"))]), _: 1 }), s(B, { label: "已办理长度(m)", "show-overflow-tooltip": "", "min-width": "90px", key: "handlingLength", prop: "handlingLength", align: "center" }, { default: p(({ row: { sourceRow: oe } }) => [oe.handlingLength ? (w(), Q("span", ehe, K(l(St)(oe.handlingLength, "mm", "m", 3)), 1)) : (w(), Q("span", the, "-"))]), _: 1 }), s(B, { label: "本次办理长度(m)", "show-overflow-tooltip": "", "min-width": "90px", key: "nowLength", prop: "nowLength", align: "center" }, { default: p(({ row: { sourceRow: oe } }) => [oe.nowLength ? (w(), Q("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: (ye) => R(oe) }, K(l(St)(oe.nowLength, "mm", "m", 3)), 9, ihe)) : (w(), Q("span", ahe, "-"))]), _: 1 })], 64))], 64)) : H("", true), s(B, { key: "boolComplete", prop: "boolComplete", label: "是否齐套", align: "center", width: "80" }, { default: p(({ row: oe }) => [s(q, { modelValue: oe.boolComplete, "onUpdate:modelValue": (ye) => oe.boolComplete = ye, label: "齐套", disabled: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"]), y.ApprovalFlag ? (w(), U(j, { key: 0, modelValue: V.value, "onUpdate:modelValue": L[3] || (L[3] = (oe) => V.value = oe), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])) : H("", true), s(Y8, { modelValue: u.value, "onUpdate:modelValue": L[4] || (L[4] = (oe) => u.value = oe), currentRow: g.value, "max-height": l(f) }, null, 8, ["modelValue", "currentRow", "max-height"])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, K8 = ut(lhe, [["__scopeId", "data-v-477637ab"]]), ohe = Object.freeze(Object.defineProperty({ __proto__: null, default: K8 }, Symbol.toStringTag, { value: "Module" }));
function nhe(e) {
  return W({ url: "/api/wms/shipment/record", method: "get", params: e });
}
function W8(e) {
  return W({ url: `/api/wms/shipment/selectById/${e}`, method: "get" });
}
function she(e) {
  return W({ url: "/api/wms/shipment/review", method: "put", params: e });
}
function rhe(e) {
  return W({ url: "/api/wms/shipment/revocation", method: "put", params: e });
}
const Byt = { get: nhe, detail: W8 };
const uhe = { key: 0, class: "footer" }, che = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false }, componentName: { type: [String, Number], default: void 0 }, journalId: { type: [String, Number], default: void 0 } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(), r = Z(), E = Z(false), y = Z([...Da, ["outboundAddress", ["parse-enum", So]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), { CRUD: b, crud: V, detail: M } = qi(), { maxHeight: g } = Kt({ mainBox: ".receipt-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => Ee(() => !V.detailLoading)), S = Ee(() => "配套件领用出库明细");
  b.HOOK.beforeDetailLoaded = async (_, f) => {
    var m;
    r.value = void 0, (m = f.wmsShipmentReceiveApproveDetailDTOS) == null || m.forEach((R) => {
      R.width = R.outWidth, R.thickness = R.outThickness, R.length = R.outLength, R.specification = R.outSpecification, R.standardId = R.outStandardId, R.standardName = R.outStandardName, R.brand = R.outBrand, R.color = R.outColor, R.heatNoAndBatchNo = R.outHeatNoAndBatchNo;
    }), await Qt(f.wmsShipmentReceiveApproveDetailDTOS), await Ut(f.wmsShipmentReceiveApproveDetailDTOS, { toSmallest: false, toNum: true }, { quantity: ["outQuantity"], mete: ["outMete"] });
  };
  function h(_) {
    return Hi(_, { props: ["outQuantity", "outMete"] });
  }
  async function T(_) {
    try {
      if (E.value = true, _ === Lt.REFUSE.V && !A(r.value)) {
        ot.error("请输入审批意见");
        return;
      }
      const f = { approveRecordId: M.approveRecordId, decision: _, opinion: r.value };
      await she(f), _ === Lt.PASS.V ? ot.success("审批通过") : ot.error("审批驳回"), n("auditSuccess");
    } catch (f) {
      console.log("配套件发运冻结出库审核提交", f);
    } finally {
      E.value = false;
    }
  }
  return (_, f) => {
    const m = wi, R = Ve("common-button"), v = La, N = pa, P = vt, L = Ve("common-table"), O = Mt, x = Ve("common-drawer");
    return w(), U(x, { ref_key: "drawerRef", ref: u, "before-close": l(V).cancelDetail, "content-loading": l(V).detailLoading, "show-close": true, title: S.value, visible: l(V).detailVisible, "custom-class": "receipt-record-detail", size: "90%" }, { titleAfter: p(() => {
      var I, Y;
      return [l(M).applicantName ? (w(), U(m, { key: 0, effect: "dark" }, { default: p(() => [Te(K(`申请人：${l(M).applicantName}`), 1)]), _: 1 })) : H("", true), l(M).createTime ? (w(), U(m, { key: 1, effect: "plain", type: "warning" }, { default: p(() => [Te(K(`出库申请时间：${l(Qi)(l(M).createTime)}`), 1)]), _: 1 })) : H("", true), l(M).reviewStatus ? (w(), U(m, { key: 2, size: "default", type: (I = l(Lt).V[l(M).reviewStatus]) == null ? void 0 : I.TAG }, { default: p(() => [Te(K(l(Lt).VL[l(M).reviewStatus]), 1)]), _: 1 }, 8, ["type"])) : H("", true), ((Y = l(M).wmsApproveRecordFlowDTO) == null ? void 0 : Y.length) !== 0 ? (w(), U(v, { key: 3, width: 400, placement: "bottom", trigger: "hover" }, { reference: p(() => [s(R, { size: "default" }, { default: p(() => f[3] || (f[3] = [Te("查看审批记录")])), _: 1, __: [3] })]), default: p(() => [s(tl, { data: l(M).wmsApproveRecordFlowDTO || [] }, null, 8, ["data"])]), _: 1 })) : H("", true)];
    }), titleRight: p(() => [c.ApprovalFlag ? (w(), Q("div", uhe, [s(N, { title: "确认通过", onConfirm: f[0] || (f[0] = (I) => T(l(Lt).PASS.V)) }, { reference: p(() => [s(R, { loading: E.value, class: "filter-item", size: "default", type: "success" }, { default: p(() => f[4] || (f[4] = [Te("通过")])), _: 1, __: [4] }, 8, ["loading"])]), _: 1 }), s(N, { title: "确认驳回", onConfirm: f[1] || (f[1] = (I) => T(l(Lt).REFUSE.V)) }, { reference: p(() => [s(R, { loading: E.value, class: "filter-item", size: "default", type: "danger" }, { default: p(() => f[5] || (f[5] = [Te(" 驳回")])), _: 1, __: [5] }, 8, ["loading"])]), _: 1 })])) : H("", true)]), content: p(() => [s(L, { data: l(M).wmsShipmentReceiveApproveDetailDTOS, "data-format": y.value, "max-height": l(g), showEmptySymbol: "", "show-summary": "", "summary-method": h, "row-key": "id" }, { default: p(() => [s(P, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), s(P, { key: "detailName", prop: "detailName", label: "配套件名称", align: "left", "min-width": "100px" }), s(P, { key: "serialNumber", align: "left", label: "物料编码", prop: "serialNumber", "show-overflow-tooltip": "", width: "100" }), s(P, { key: "classifyName", align: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "", "min-width": "100" }), s(P, { key: "specification", label: "规格", align: "center", prop: "specification", "show-overflow-tooltip": "", "min-width": "120px" }, { default: p(({ row: { sourceRow: I } }) => [C("span", null, K(l(Ki)(I)), 1)]), _: 1 }), s(P, { key: "brand", align: "left", label: "品牌", prop: "brand", "show-overflow-tooltip": "", width: "100" }), s(P, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", width: "80px" }), s(P, { key: "outQuantity", prop: "outQuantity", label: "出库数量", align: "center", "show-overflow-tooltip": "", width: "80px" }), s(P, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", width: "80px" }), s(P, { key: "outMete", prop: "outMete", label: "出库核算量", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }), s(P, { key: "project", prop: "project", label: "领用项目", align: "center", "show-overflow-tooltip": "", "min-width": "150px" }), s(P, { key: "outboundAddress", prop: "outboundAddress", label: "目的地", align: "center", "show-overflow-tooltip": "", "in-width": "80px" }), s(P, { key: "mesWorkshop.name", prop: "mesWorkshop.name", label: "领用车间", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }), s(P, { key: "recipientName", prop: "recipientName", label: "领用人", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }), s(P, { key: "remark", prop: "remark", label: "备注", align: "center", "show-overflow-tooltip": "", "min-width": "80px" })]), _: 1 }, 8, ["data", "data-format", "max-height"]), c.ApprovalFlag ? (w(), U(O, { key: 0, modelValue: r.value, "onUpdate:modelValue": f[2] || (f[2] = (I) => r.value = I), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])) : H("", true)]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, j8 = ut(che, [["__scopeId", "data-v-31585a04"]]), dhe = Object.freeze(Object.defineProperty({ __proto__: null, default: j8 }, Symbol.toStringTag, { value: "Module" }));
function Hyt(e) {
  return W({ module: "", url: "/api/scm/supplierEvaluate/list", method: "get", params: e, cancelKey: false });
}
function qyt(e) {
  return W({ module: "", url: "/api/scm/supplierEvaluate/evaluate/list", method: "get", params: e, cancelKey: false });
}
function Gyt(e) {
  return W({ module: "", url: `/api/scm/supplierEvaluate/latest/${e}`, method: "get", cancelKey: false });
}
function Qyt(e) {
  return W({ module: "", url: "/api/scm/supplierEvaluate/add", method: "post", data: e });
}
function Zyt(e) {
  return W({ module: "", url: "/api/scm/supplierEvaluate/download", method: "get", params: e, responseType: "blob", cancelKey: false });
}
function Jyt(e) {
  return W({ module: "", url: `/api/scm/supplierEvaluate/export/${e}`, method: "get", responseType: "blob", cancelKey: false });
}
function F8(e) {
  return W({ module: "", url: `/api/scm/supplierEvaluate/detail/${e}`, method: "get", cancelKey: false });
}
function mhe(e) {
  return W({ module: "", url: "/api/scm/supplierEvaluate/check", method: "put", params: e });
}
function phe(e) {
  return W({ module: "", url: `/api/scm/supplierEvaluate/cancelApprove/${e}`, method: "put" });
}
function hhe(e) {
  return W({ url: "/api/contract/pre/registration/list", method: "get", params: e });
}
function fhe(e) {
  return W({ url: "/api/contract/pre/registration/save", method: "post", data: e });
}
function ghe(e) {
  return W({ url: "/api/contract/pre/registration/edit", method: "put", data: e });
}
function z8(e) {
  return W({ url: `/api/contract/pre/registration/${e}`, method: "get" });
}
function Ehe(e) {
  return W({ url: "/api/contract/pre/registration/review", method: "put", params: e });
}
function yhe(e) {
  return W({ url: `/api/contract/pre/registration/revocation/${e.id}`, method: "post" });
}
function The(e) {
  return W({ url: "/api/contract/pre/registration/unQuote", method: "get" });
}
function Xyt(e) {
  return W({ url: "/api/contract/pre/registration/export", method: "get", responseType: "blob", params: e });
}
const _he = { add: fhe, detail: z8, edit: ghe, get: hhe };
function bhe(e) {
  return W({ url: "/api/contract/registration/listJudge", method: "get", params: e });
}
function B8(e) {
  return W({ url: "/api/contract/registration/saveJudge", method: "post", data: e });
}
function Vhe(e) {
  return W({ url: "/api/contract/registration/edit", method: "put", data: e });
}
function H8(e) {
  return W({ url: `/api/contract/registration/judge/${e}`, method: "get" });
}
function whe(e) {
  return W({ url: "/api/contract/registration/review", method: "put", params: e });
}
function She(e) {
  return W({ url: `/api/contract/registration/revocation/${e.id}`, method: "post" });
}
function $yt(e) {
  return W({ url: "/api/contract/registration/exportJudge", method: "get", responseType: "blob", params: e });
}
